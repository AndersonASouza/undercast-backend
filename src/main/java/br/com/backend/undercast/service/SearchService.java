package br.com.backend.undercast.service;

import br.com.backend.undercast.dto.PodcastDTO;
import br.com.backend.undercast.dto.ResultDTO;

import java.util.List;

public interface SearchService {

    public List<ResultDTO> getEpisodesInfo(Integer top);

    public List<PodcastDTO> search(String stringQuery, Integer limit);

}
