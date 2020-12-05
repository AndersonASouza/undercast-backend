package br.com.backend.undercast.controller;

import br.com.backend.undercast.dto.ListEpisodesRequestDTO;
import br.com.backend.undercast.dto.ListEpisodesResponseDTO;
import com.icosillion.podengine.models.Episode;
import com.icosillion.podengine.models.Podcast;
import io.swagger.annotations.Api;
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

    @GetMapping("/index")
    public ResponseEntity<ListEpisodesResponseDTO> getEpisodes(@RequestHeader String feedUrl) {
        try {
            ListEpisodesResponseDTO response = new ListEpisodesResponseDTO();
            Podcast podcast = new Podcast(new URL(feedUrl));
            List<Episode> episodes = podcast.getEpisodes();
            response.setEpisodes(episodes);
            return ResponseEntity.ok().body(response);
        }catch (Exception exception){
            return ResponseEntity.notFound().build();
        }

    }
}
