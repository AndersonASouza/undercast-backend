package br.com.backend.undercast.controller;

import br.com.backend.undercast.dto.PodcastDTO;
import br.com.backend.undercast.dto.RankResultDTO;
import br.com.backend.undercast.service.FeedService;
import br.com.backend.undercast.service.SearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(value = "Rank controller")
public class RankController {

    @Autowired
    public FeedService feedService;

    @Autowired
    public SearchService serchService;

    public static final Logger LOGGER = LoggerFactory.getLogger(RankController.class);

    @CrossOrigin
    @GetMapping("/rank")
    @ApiOperation(value = "Retorna os top podcasts do Brasil")
    public ResponseEntity<List<PodcastDTO>> getRank(@RequestParam(required = true, defaultValue = "10", name = "rank") Integer top) {
        LOGGER.debug("Get top 10 from Brazil");
        List<RankResultDTO> rankResultDTO = feedService.getTopBrazilFeed(top);

        List<PodcastDTO> result = rankResultDTO.stream().map((item -> serchService.lookup(item.getItunesId())))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(result);
    }
}
