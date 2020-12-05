package br.com.backend.undercast.repository;

import br.com.backend.undercast.model.PodcastModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodcastRepository extends JpaRepository<PodcastModel, Long> {
}
