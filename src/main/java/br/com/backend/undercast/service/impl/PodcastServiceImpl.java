package br.com.backend.undercast.service.impl;

import br.com.backend.undercast.dto.ListEpisodesResponseDTO;
import br.com.backend.undercast.service.PodcastService;
import com.icosillion.podengine.exceptions.InvalidFeedException;
import com.icosillion.podengine.exceptions.MalformedFeedException;
import com.icosillion.podengine.models.Episode;
import com.icosillion.podengine.models.Podcast;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class PodcastServiceImpl implements PodcastService {

    @Override
    public List<Episode> getEpisodes(String rssURL) throws InvalidFeedException, MalformedFeedException, MalformedURLException {ListEpisodesResponseDTO response = new ListEpisodesResponseDTO();
        Podcast podcast = new Podcast(new URL(rssURL));
        return podcast.getEpisodes();
    }
}
