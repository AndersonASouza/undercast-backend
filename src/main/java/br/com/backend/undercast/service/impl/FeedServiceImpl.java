package br.com.backend.undercast.service.impl;

import br.com.backend.undercast.dto.ResultDTO;
import br.com.backend.undercast.service.FeedService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FeedServiceImpl implements FeedService {
    public static final String ITUNES_RSS_FEED = "https://rss.itunes.apple.com/api/v1/br/podcasts/top-podcasts/all/10/explicit.json";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<ResultDTO> getTopBrazilFeed(Integer top) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(ITUNES_RSS_FEED.replace("10",top.toString()), String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response.getBody());
            JsonNode dataNode = rootNode.at("/feed/results");
            return List.of(mapper.treeToValue(dataNode, ResultDTO[].class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
