package br.com.backend.undercast.service;

import br.com.backend.undercast.dto.RankResultDTO;

import java.util.List;

public interface FeedService {

    public List<RankResultDTO> getTopBrazilFeed(Integer top);

}
