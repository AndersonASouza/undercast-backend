package br.com.backend.undercast;

import br.com.backend.undercast.repository.PodcastRepository;
import br.com.backend.undercast.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UndercastApplication {

	@Autowired
	PodcastRepository podcastRepository;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(UndercastApplication.class, args);
	}

//	@PostConstruct
//	public void test(){
//
//		Podcast decrepitos = new Podcast();
//		Podcast mamilos = new Podcast();
//		Podcast nerdcast = new Podcast();
//
//		decrepitos.setName("Decrepitos");
//		decrepitos.setItunesId("951399966");
//		mamilos.setName("Mamilos");
//		mamilos.setItunesId("942491627");
//		nerdcast.setName("NerdCast");
//		nerdcast.setItunesId("381816509");
//
//		try{
//			decrepitos = podcastRepository.save(decrepitos);
//			mamilos = podcastRepository.save(mamilos);
//			nerdcast = podcastRepository.save(nerdcast);
//		}catch (Exception exception){
//
//		}
//
//		User ana = new User();
//		ana.setEmail("aclopess@outlook.com");
//		ana.setPassword("senha");
//		ana.setName("Ana Caroline Lopes dos Santos");
//
//		User anderson = new User();
//		anderson.setEmail("andersonandredesouza02@hotmail.com");
//		anderson.setPassword("123");
//		anderson.setName("Anderson Andre de Souza");
//
////		userRepository.save(anderson);
////		userRepository.save(ana);
//
////		List podcastsAnderson = new ArrayList();
////		podcastsAnderson.add(decrepitos);
////		podcastsAnderson.add(mamilos);
////		anderson.setPodcasts(podcastsAnderson);
////		.add(decrepitos);
////		anderson.getPodcasts().add(mamilos);
//
////		List podcastsAna = new ArrayList();
////		podcastsAna.add(mamilos);
////		ana.setPodcasts(podcastsAna);
////		.add(mamilos);
//
////		try{
////			userRepository.save(anderson);
////			userRepository.save(ana);
////		}catch (Exception exception){
//			anderson =  userRepository.save(anderson);
//			ana = userRepository.save(ana);
////		}
//
//		List podcastsAna = new ArrayList();
//		podcastsAna.add(mamilos);
//		ana.setPodcasts(podcastsAna);
//
//		List podcastsAnderson = new ArrayList();
//		podcastsAnderson.add(decrepitos);
//		podcastsAnderson.add(mamilos);
//		anderson.setPodcasts(podcastsAnderson);
//
//		userRepository.save(anderson);
//		userRepository.save(ana);
//
//	}

}
