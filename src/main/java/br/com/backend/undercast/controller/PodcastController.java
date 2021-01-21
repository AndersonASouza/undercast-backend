package br.com.backend.undercast.controller;

import br.com.backend.undercast.dto.EpisodeDTO;
import br.com.backend.undercast.dto.ListEpisodesResponseDTO;
import br.com.backend.undercast.service.PodcastService;
import com.icosillion.podengine.models.Episode;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("podcast")
@Api(value = "Podcast controller")
@CrossOrigin
public class PodcastController {

    @Autowired
    private PodcastService podcastService;

    public static final Logger LOGGER = LoggerFactory.getLogger(PodcastController.class);

    @GetMapping("/index")
    public ResponseEntity<ListEpisodesResponseDTO> getEpisodes(@RequestHeader String feedUrl) {
        try {
            ListEpisodesResponseDTO response = new ListEpisodesResponseDTO();
            List<Episode> episodes = podcastService.getEpisodes(feedUrl);
            List<EpisodeDTO> episodesDTO = new ArrayList<>();

            for (Episode episode: episodes){
                EpisodeDTO episodeDTO = new EpisodeDTO();
                episodeDTO.setAudioUrl(episode.getEnclosure().getURL().toURI().toString());
                episodeDTO.setAuthor(episode.getAuthor());
                episodeDTO.setDescription(episode.getDescription());
                episodeDTO.setDuration(episode.getITunesInfo().getDuration());
                episodeDTO.setImage(episode.getITunesInfo().getImageString());
                episodeDTO.setPubDate(episode.getPubDate());
                episodeDTO.setTitle(episode.getTitle());
                episodesDTO.add(episodeDTO);
            }

            response.setEpisodes(episodesDTO);
            LOGGER.debug("Episodes: {}", episodes.size());
            return ResponseEntity.ok().body(response);
        }catch (Exception exception){
            return ResponseEntity.notFound().build();
        }
    }
}
