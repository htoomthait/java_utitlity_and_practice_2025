package com.example.liquid.database.practice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomRespond<T> {

    private String respondCode;
    private String status;
    private String message;
    private T data;


    public static <T> CustomRespond<T> of(String respondCode, String status, String message, T data) {
        return CustomRespond.<T>builder()
                .respondCode(respondCode)
                .status(status)
                .message(message)
                .data(data)
                .build();
    }
}
