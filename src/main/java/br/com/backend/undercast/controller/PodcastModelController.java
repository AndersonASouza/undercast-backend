package br.com.backend.undercast.controller;

import br.com.backend.undercast.dto.CreatePodcastRequestDTO;
import br.com.backend.undercast.model.PodcastModel;
import br.com.backend.undercast.model.User;
import br.com.backend.undercast.repository.PodcastRepository;
import br.com.backend.undercast.repository.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("podcast-model")
@Api(value = "Podcast Model controller")
@CrossOrigin
public class PodcastModelController {

    @Autowired
    PodcastRepository podcastRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/create")
    public void createPodcast(@Valid @RequestBody CreatePodcastRequestDTO request) {
        PodcastModel podcastModel = new PodcastModel();
        podcastModel.setItunesId(request.getItunesId());
        podcastModel.setName(request.getName());
        podcastRepository.save(podcastModel);
    }

    @GetMapping("/listeners")
    public ResponseEntity<List<User>> index(@RequestHeader long podcast) {
        Optional<PodcastModel> findedPodcast = podcastRepository.findById(podcast);
        if (findedPodcast.isPresent()) {
            List<User> users = userRepository.findUsers(podcast);
            return ResponseEntity.ok().body(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/index")
    public ResponseEntity<List<PodcastModel>> index() {
        List<PodcastModel> podcastModel = podcastRepository.findAll();
        return ResponseEntity.ok().body(podcastModel);
    }

}
