package info.htoomaungthait.ems_backend.util;

import info.htoomaungthait.ems_backend.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil<A> {

    public static <T> ResponseEntity<ApiResponse<T>> success(T data) {
        return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
    }

    public static <T>ResponseEntity<ApiResponse<T>>error(String message, int status){
        return ResponseEntity.status(status).body(new ApiResponse<>(status, message, null));
    }

    public static <T> ResponseEntity<ApiResponse<T>> successWithPagination(T data) {
        return ResponseEntity.ok(new ApiResponse<>(200, "success", data));
    }
}
