package br.com.backend.undercast.controller;

import br.com.backend.undercast.dto.CreateUserRequestDTO;
import br.com.backend.undercast.dto.FollowPodcastDTO;
import br.com.backend.undercast.model.PodcastModel;
import br.com.backend.undercast.model.User;
//import br.com.backend.undercast.model.UserPodcast;
//import br.com.backend.undercast.model.UserPodcastId;
//import br.com.backend.undercast.repository.UserPodcastRepository;
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
@RequestMapping("user")
@Api(value = "User controller")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PodcastRepository podcastRepository;

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity createUser(@Valid @RequestBody CreateUserRequestDTO request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @PostMapping("/follow")
    public ResponseEntity followPodcast(@Valid @RequestBody FollowPodcastDTO request) {
        Optional<User> user = userRepository.findById(request.getUser());
        Optional<PodcastModel> podcast = podcastRepository.findById(request.getPodcast());
        if (user.isPresent() && podcast.isPresent()){
            user.get().getPodcasts().add(podcast.get());
//            podcast.get().getUsers().add(user.get());
            userRepository.save(user.get());
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @CrossOrigin
    @GetMapping("/follows")
    public ResponseEntity<List<PodcastModel>> index(@Valid @RequestHeader Long user) {
        Optional<User> findedUser = userRepository.findById(user);
        if (findedUser.isPresent()) {
//            List<Podcast> podcasts = new ArrayList<Podcast>();
//            podcasts.addAll(findedUser.get().getPodcasts());
            List<PodcastModel> podcastModels = findedUser.get().getPodcasts();
            return ResponseEntity.ok().body(podcastModels);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @GetMapping("/index")
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok().body(users);
    }
}
