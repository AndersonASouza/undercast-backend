package br.com.backend.undercast.controller;

import br.com.backend.undercast.dto.ListEpisodesRequestDTO;
import br.com.backend.undercast.dto.ListEpisodesResponseDTO;
import br.com.backend.undercast.service.PodcastService;
import com.icosillion.podengine.models.Episode;
import com.icosillion.podengine.models.Podcast;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("podcast")
@Api(value = "Podcast controller")
@CrossOrigin
public class PodcastController {

    @Autowired
    private PodcastService podcastService;

    @GetMapping("/index")
    public ResponseEntity<ListEpisodesResponseDTO> getEpisodes(@RequestHeader String feedUrl) {
        try {
            ListEpisodesResponseDTO response = new ListEpisodesResponseDTO();
            List<Episode> episodes = podcastService.getEpisodes(feedUrl);
            response.setEpisodes(episodes);
            return ResponseEntity.ok().body(response);
        }catch (Exception exception){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/ ")
    public ResponseEntity<String> getDownloadLink(@RequestHeader String feedUrl, @RequestParam int index) {
        try {
            String url = podcastService.getDownloadLink(feedUrl, index);
            return ResponseEntity.ok().body(url);
        }catch (Exception exception){
            return ResponseEntity.notFound().build();
        }
    }
}
