package com.example.springbootv2713helloworldexample.exception;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class UrlNotAccessFailureAnalyzer extends AbstractFailureAnalyzer<UrlAccessException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, UrlAccessException cause) {
        return new FailureAnalysis("Unable to access the URL" + cause.getUrl(), "Ensure the URL is accessible", cause);
    }
}
