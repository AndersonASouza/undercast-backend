package br.com.backend.undercast.repository;

import br.com.backend.undercast.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(
//            "SELECT u FROM user u, user_podcast j JOIN j.podcast_id u"
        value = "SELECT * " +
                "FROM USER " +
                "INNER JOIN USER_PODCAST " +
                "ON USER.ID = USER_PODCAST.USER_ID " +
                "WHERE USER_PODCAST.PODCAST_ID = ?1",
        nativeQuery = true
    )
    List<User> findUsers(long podcast);

    Optional<User> findByName(String name);
}
