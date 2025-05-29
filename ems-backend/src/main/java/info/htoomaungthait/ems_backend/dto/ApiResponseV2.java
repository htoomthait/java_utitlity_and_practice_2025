package info.htoomaungthait.ems_backend.dto;

public class ApiResponseV2<T> {

    private int statusCode;
    private  String status;
    private String message;
    private T data;



    public  ApiResponseV2(String status,  String message, T data){
        this.status = status;
        this.message = message;
        this.data = data;

    }

    public  ApiResponseV2(){

    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }


    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
