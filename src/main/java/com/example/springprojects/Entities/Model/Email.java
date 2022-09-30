package com.example.springprojects.Entities.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {
    private String body;
    private String emailTo;
    private String emailFrom;
    private String file;

    private String link;

    @Override
    public String toString() {
        return "Email{" +
                "body='" + body + '\'' +
                ", emailTo='" + emailTo + '\'' +
                ", emailFrom='" + emailFrom + '\'' +
                ", file='" + file + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
