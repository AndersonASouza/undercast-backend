package br.com.backend.undercast.service;

import com.icosillion.podengine.exceptions.InvalidFeedException;
import com.icosillion.podengine.exceptions.MalformedFeedException;
import com.icosillion.podengine.models.Episode;

import java.net.MalformedURLException;
import java.util.List;

public interface PodcastService {

    public String getDownloadLink(String rssURL, int episode) throws MalformedURLException, InvalidFeedException, MalformedFeedException;

    public List<Episode> getEpisodes(String rssURL) throws MalformedURLException, InvalidFeedException, MalformedFeedException;

}
