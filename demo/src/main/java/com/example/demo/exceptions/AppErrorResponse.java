package com.example.demo.exceptions;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppErrorResponse {

    private int status;
    private String message;
    private long timestamp;
}