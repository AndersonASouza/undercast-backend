package br.com.backend.undercast.controller;

import br.com.backend.undercast.dto.ResultDTO;
import br.com.backend.undercast.service.FeedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@Api(value = "Rank controller")
public class RankController {
    @Autowired
    public FeedService service;

    @CrossOrigin
    @GetMapping("/rank")
    @ApiOperation(value = "Retorna os top podcasts do Brasil")
    public ResponseEntity<List<ResultDTO>> getRank(@RequestParam(required = true, defaultValue = "10", name = "rank") Integer top) {
        return ResponseEntity.ok().body(service.getTopBrazilFeed(top));
    }
}
