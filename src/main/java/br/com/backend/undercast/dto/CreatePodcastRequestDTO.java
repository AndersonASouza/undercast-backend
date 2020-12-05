package br.com.backend.undercast.dto;

import javax.validation.constraints.NotNull;

public class CreatePodcastRequestDTO {

    @NotNull
    public String name;

    @NotNull
    public String itunesId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItunesId() {
        return itunesId;
    }

    public void setItunesId(String itunesId) {
        this.itunesId = itunesId;
    }
}
