package com.example.demo.mail;

import com.example.demo.dto.UserDto;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailService {
    final Configuration configuration;
    final JavaMailSender javaMailSender;

    public MailService(Configuration configuration, JavaMailSender javaMailSender) {
        this.configuration = configuration;
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(UserDto userDto) throws MessagingException, IOException, TemplateException {
        String from = "b08545a2a4-2ae9a0@inbox.mailtrap.io";

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setFrom(from);
        helper.setSubject("New user confirmation");
        helper.setTo(userDto.getEmail());
        String emailContent = getEmailContent(userDto);
        helper.setText(emailContent, true);
        javaMailSender.send(mimeMessage);
    }

    String getEmailContent(UserDto userDto) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("userDto", userDto);
        configuration.getTemplate("emailDesign.ftl").process(model, stringWriter);
        return stringWriter.getBuffer().toString();
    }
}
