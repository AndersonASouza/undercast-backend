package br.com.backend.undercast.dto;

import javax.validation.constraints.NotNull;

public class FollowPodcastDTO {

    @NotNull
    private long user;

    @NotNull
    private long podcast;

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getPodcast() {
        return podcast;
    }

    public void setPodcast(long podcast) {
        this.podcast = podcast;
    }
}
