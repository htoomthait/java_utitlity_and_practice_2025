package info.htoomaungthait.ems_backend.util;

import info.htoomaungthait.ems_backend.dto.ApiResponse;
import info.htoomaungthait.ems_backend.dto.ApiResponseV2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil<T> {

    private int httpStatus;
    private int statusCode;
    private String  status;
    private String message;
    private T data;

    // Private constructor to enforce static instantiation
    private ResponseUtil() {}

    // Static factory method to get instance
    public static <T> ResponseUtil<T> getInstance() {
        return new ResponseUtil<>();
    }

    // Set http status code (chainable)
    public ResponseUtil<T> httpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    // Set status code (chainable)
    public ResponseUtil<T> statusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    // Set status (chainable)
    public ResponseUtil<T> status(String status) {
        this.status = status;
        return this;
    }

    // Set message (chainable)
    public ResponseUtil<T> message(String message) {
        this.message = message;
        return this;
    }

    // Set data (chainable)
    public ResponseUtil<T> data(T data) {
        this.data = data;
        return this;
    }

    // Build final ResponseEntity with ApiResponse wrapper
    public ResponseEntity<ApiResponseV2<T>> build() {
        ApiResponseV2<T> response = new ApiResponseV2<>();
        response.setStatusCode(statusCode);
        response.setStatus(status);
        response.setMessage(message);
        response.setData(data);
        return ResponseEntity.status(httpStatus).body(response);
    }


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



