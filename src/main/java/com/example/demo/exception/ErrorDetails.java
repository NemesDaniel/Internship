package com.example.demo.exception;

import lombok.*;

import javax.persistence.Entity;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorDetails {

    private Date timestamp;

    private String message;

    private String details;

    private String httpCodeMessage;

}
