package br.com.backend.undercast.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenreDTO {
    @JsonProperty("genreId")
    String id;
    String name;
    String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
