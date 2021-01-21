package br.com.backend.undercast.configuration;

import org.springframework.beans.factory.annotation.Value;

//@org.springframework.context.annotation.Configuration
public class Configuration {

//    @Value("${listen-api.base-url}")
    private String listenApiBaseURL;

//    @Value("${listen-api.key}")
    private String listenApiKey;

    public String getListenApiBaseURL() {
        return listenApiBaseURL;
    }

    public void setListenApiBaseURL(String listenApiBaseURL) {
        this.listenApiBaseURL = listenApiBaseURL;
    }

    public String getListenApiKey() {
        return listenApiKey;
    }

    public void setListenApiKey(String listenApiKey) {
        this.listenApiKey = listenApiKey;
    }
}
