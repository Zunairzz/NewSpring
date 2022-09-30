package com.example.springprojects.Entities.Dto;

import com.example.springprojects.Utils.Constants;

import java.time.ZonedDateTime;

public class UserEmailDto {

    public static String genRanStr() {

        int RAND_STR_SIZE = 5;

        String AlphaNumericString = Constants.ALPHANUMERIC_STRING;
        StringBuilder sb = new StringBuilder(RAND_STR_SIZE);
        for (int i = 0; i < RAND_STR_SIZE; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString() + ZonedDateTime.now().toEpochSecond();
    }
}
