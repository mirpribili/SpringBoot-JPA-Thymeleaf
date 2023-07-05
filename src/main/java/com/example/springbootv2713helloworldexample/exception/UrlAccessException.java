package com.example.springbootv2713helloworldexample.exception;

import lombok.Getter;

public class UrlAccessException extends RuntimeException{
    @Getter
    private String url;
    public UrlAccessException(String url){
        this(url, null);
    }
    public UrlAccessException(String url, Throwable cause){
        super("URL " + url + " is not accessible", cause);
        this.url = url;
    }
}
