package br.com.backend.undercast.dto;

import java.util.List;

public class ListEpisodesResponseDTO {

    private List<EpisodeDTO> episodes;

    public List<EpisodeDTO> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<EpisodeDTO> episodes) {
        this.episodes = episodes;
    }

//    private List<Episode> episodes;
//
//    public List<Episode> getEpisodes() {
//        return episodes;
//    }
//
//    public void setEpisodes(List<Episode> episodes) {
//        this.episodes = episodes;
//    }
}
