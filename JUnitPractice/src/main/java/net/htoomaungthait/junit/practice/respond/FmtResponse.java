package net.htoomaungthait.junit.practice.respond;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FmtResponse<T> {

    private String statusCode;

    private String message;

    private T data;

    public static <T> FmtResponse<T> of(String statusCode, String message, T data) {
        return FmtResponse.<T>builder()
                .statusCode(statusCode)
                .message(message)
                .data(data)
                .build();
    }
}
