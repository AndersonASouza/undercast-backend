package br.com.backend.undercast.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedDTO {
    private List<RankResultDTO> result;
}
