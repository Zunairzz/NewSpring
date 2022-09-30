package com.example.springprojects.Entities.Dto;

import com.example.springprojects.Entities.Model.Email;
import com.example.springprojects.Utils.Response;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class EmailDto {

    public static JsonArray getJsonResponse(List<Email> email, String subject) {
        JsonArray jArray = new JsonArray();
        for (Email e : email) {
            jArray.add(getJsonResponse(e, subject));
        }
        return jArray;
    }

    public static JsonObject getJsonResponse(Email email, String subject) {
        JsonObject object = new JsonObject();
        object.addProperty("subject", subject);
        object.addProperty("body", email.getBody());
        object.addProperty("emailTo", email.getEmailTo());
        object.addProperty("emialFrom", email.getEmailFrom());
        return object;
    }
}
