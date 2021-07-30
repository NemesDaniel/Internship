package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User insertUser(UserDto userDto){
        String encodedPassword = this.passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);
        userDto.setRole("REGULAR");
        userDto.setCreationDate(Date.from(Instant.now()));
        User user = objectMapper.convertValue(userDto, new TypeReference<User>(){});
        return userRepository.save(user);
    }

    public User updateUser(UserDto userDto){
        User user = objectMapper.convertValue(userDto, new TypeReference<User>(){});
        return userRepository.save(user);
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    public void delete_user(User user){
        userRepository.delete(user);
    }

    public Optional<User> findUser(Integer id){
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    public List<User> getUsers(){
        return (List<User>) userRepository.findAll();
    }

    public User findByEmail(String email){
        User user = userRepository.findByEmail(email);
        return user;
    }

}
