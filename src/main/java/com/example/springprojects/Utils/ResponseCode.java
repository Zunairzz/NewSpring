package com.example.springprojects.Utils;

import org.springframework.http.HttpStatus;

public enum ResponseCode {

    DUPLICATE_ENTRY("", HttpStatus.UNPROCESSABLE_ENTITY, false),

    SERVICE_ERROR("Internal Service Error", HttpStatus.INTERNAL_SERVER_ERROR, false),

    UNMODIFIED("", HttpStatus.NOT_MODIFIED, false),

    RECORD_NOT_FOUND("Invalid request data", HttpStatus.UNPROCESSABLE_ENTITY, true),

    BAD_REQUEST("Invalid request data", HttpStatus.BAD_REQUEST, true),

    EMPTY_REQUEST("Empty request body, nothing changed", HttpStatus.NO_CONTENT, true),

    SUCCESS("", HttpStatus.OK, true),

    PARTIAL_SUCCESS("Some records not saved", HttpStatus.PARTIAL_CONTENT, true),

    NOT_ACCEPTABLE("", HttpStatus.NOT_ACCEPTABLE, false);

    private final String alias;
    private final HttpStatus httpStatus;
    private final Boolean state;

    ResponseCode(String alias, HttpStatus httpStatus, Boolean state) {
        this.alias = alias;
        this.httpStatus = httpStatus;
        this.state = state;
    }

    public String getAlias() {
        return alias;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Boolean getState() {
        return state;
    }
}
