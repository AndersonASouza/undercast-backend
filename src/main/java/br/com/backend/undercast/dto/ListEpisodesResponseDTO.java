package br.com.backend.undercast.dto;

import com.icosillion.podengine.models.Episode;

import java.util.List;

public class ListEpisodesResponseDTO {
    private List<Episode> episodes;

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }
}
