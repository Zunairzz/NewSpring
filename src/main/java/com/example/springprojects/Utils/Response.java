package com.example.springprojects.Utils;

public class Response<T> {

    private ResponseCode code;
    private String message;
    private T data;

    public Response(ResponseCode code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response(ResponseCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(ResponseCode code, T data) {
        this.code = code;
        this.data = data;
    }

    public Response(ResponseCode code) {
        this.code = code;
    }

    public Response(T data) {
        this.data = data;
    }

    public Response() {
    }

    public ResponseCode getCode() {
        return code;
    }

    public void setCode(ResponseCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
