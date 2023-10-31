package com.example.productservice.exceptionhandler;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ExceptionResponse {
    private String statusCode;
    private Date dateTimeFormat;
}
