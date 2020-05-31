package br.com.backend.undercast.service;

import br.com.backend.undercast.dto.ResultDTO;

import java.util.List;

public interface FeedService {

    public List<ResultDTO> getTopBrazilFeed(Integer top);

}
