package com.example.springprojects.Utils;

public class Constants {

    // End_Points
    public static final String EMAIL = "/email";
    public static final String EMAIL_RECIEVE = "/email/{userCode}";

    // Google_Creds
    public static final String HOST = "smtp.gmail.com";
    public static final String PORT = "465";
    public static final String SSL_ENABLE = "true";
    public static final String AUTH = "true";

    public static final String USERNAME = "oarecare.careoare1@gmail.com";
    public static final String PASSWORD = "lfmjerdtfnfedcwh";

    // Email_Creds
    public static final String EMAIL_FROM = "oarecare.careoare1@gmail.com";

    public static final String SUBJECT = "Backend_Testing";

    public static final String EMAIL_BODY = "Hi sir, Hope you are good to go.\n" +
            "You receive this email from backend.\n";

    public static final String ALERT = "<script>\n" +
            "  alert(\"You successfully unsubscribe email!\");\n" +
            "</script>";

    public static final String ALPHANUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";

}
