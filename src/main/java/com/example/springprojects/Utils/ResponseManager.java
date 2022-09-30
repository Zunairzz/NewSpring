package com.example.springprojects.Utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseManager {

    public static ResponseEntity<String> sendSuccessResponse(Object o) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("content-type", "application/json");
        Gson gson = new Gson();
        JsonObject object = new JsonObject();
        object.addProperty("message", "Success");
        object.add("data", gson.toJsonTree(o));
        return new ResponseEntity<>(object.toString(), headers, HttpStatus.OK);
    }
    public static ResponseEntity<String> sendSuccessResponse(String message, HttpStatus httpStatus) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("content-type", "application/json");
        Gson gson = new Gson();
        JsonObject object = new JsonObject();
        object.addProperty("message", message);
        return new ResponseEntity<>(object.toString(), headers, httpStatus);
    }
}


class A {

    public static void add() {

    }
}

class B extends A{

}