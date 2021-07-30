package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.kafkaService.Producer;
import com.example.demo.mail.MailService;
import com.example.demo.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
//@RequestMapping("/api/docs")
public class Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @Autowired
    Producer producer;

    @Value("${spring.datasource.username}")
    private String datasource;

    @GetMapping("/app")
    public String dataSource(){
        System.out.println(datasource);
        return datasource;
    }

    @PostMapping(value = "/user")
    public User addUser(@RequestBody UserDto userDto) {
        System.out.println("User created successfully!");
        mailService.sendEmail(userDto);
        return userService.insertUser(userDto);
    }

    @PutMapping(value = "/user")
    public User updateUser(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id){
        User user = userService.findUser(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id + ". Couldn't delete it!"));
        userService.delete_user(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/user/{id}")
    public User findUser(@PathVariable Integer id){
        return userService.findUser(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));

    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    /////////////LOGIN///////////////////
    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public String login(@RequestParam String email, @RequestParam String password){
        User user = userService.findByEmail(email);
        if(user!=null){
            String token = getJWTToken(email);
            if(user.getPassword().equals(password)){
                return "User: " + token;
            }
        }
        return "Bad credentials, try again!";
    }

    @PostMapping(value="/post")
    public void sendMessage(@RequestParam("msg") String msg) {
        producer.publishToTopic(msg);
    }


}

