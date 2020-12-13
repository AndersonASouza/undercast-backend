package br.com.backend.undercast.service.impl;

import br.com.backend.undercast.dto.PodcastDTO;
import br.com.backend.undercast.dto.ResultDTO;
import br.com.backend.undercast.service.SearchService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController("/search")
public class SearchServiceImpl implements SearchService {
    public static final String ITUNES_SEARCH_URL = "https://itunes.apple.com/search";
    public static final String PODCAST = "podcast";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<ResultDTO> getEpisodesInfo(Integer top) {
        return null;
    }

    @Override
    public List<PodcastDTO> search(String stringQuery, Integer limit) {
        String url = getURLWithParams(stringQuery, limit);
//        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        try{
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response.getBody());
            JsonNode dataNode = rootNode.at("/results");
            return List.of(mapper.treeToValue(dataNode, PodcastDTO[].class));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private String getURLWithParams(String stringQuery, Integer limit) {
        stringQuery = stringQuery.replace(" ", "+");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ITUNES_SEARCH_URL)
                .queryParam("term", stringQuery)
                .queryParam("entity", PODCAST)
                .queryParam("limit", limit);

        return builder.toUriString();
    }

    @Override
    public List<PodcastDTO> search(String stringQuery, Integer limit, String country, int genreId) {
        String url = getURLWithParams(stringQuery, limit, country, genreId);

        try{
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response.getBody());
            JsonNode dataNode = rootNode.at("/results");
            return List.of(mapper.treeToValue(dataNode, PodcastDTO[].class));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private String getURLWithParams(String stringQuery, Integer limit, String country, int genreId) {
        stringQuery = stringQuery.replace(" ", "+");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ITUNES_SEARCH_URL)
                .queryParam("term", stringQuery)
                .queryParam("entity", PODCAST)
                .queryParam("limit", limit)
                .queryParam("country", country)
                .queryParam("genreId", genreId);
        return builder.toUriString();
    }

}
