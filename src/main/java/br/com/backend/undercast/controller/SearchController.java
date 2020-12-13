package br.com.backend.undercast.controller;

import br.com.backend.undercast.dto.PodcastDTO;
import br.com.backend.undercast.service.SearchService;
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
@Api(value = "Search controller")
public class SearchController {

    @Autowired
    public SearchService service;

    @CrossOrigin
    @ApiOperation(value = "Faz uma busca na API do iTunes pelo podcast digitado")
    @GetMapping("/search")
    public ResponseEntity<List<PodcastDTO>> search(
        @RequestParam(required = true, name = "query") String searchString,
        @RequestParam(required = false, defaultValue = "50", name = "limit") String limit,
        @RequestParam(required = false, defaultValue = "BR", name = "country") String country,
        @RequestParam(required = false, name = "genreId") String genreId    ){
        if (genreId!=null){
            return ResponseEntity.ok().body(service.search(searchString,Integer.valueOf(limit), country, Integer.valueOf(genreId)));
        }else{
            return ResponseEntity.ok().body(service.search(searchString,Integer.valueOf(limit)));
        }

    }

}
