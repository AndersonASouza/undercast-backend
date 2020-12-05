package br.com.backend.undercast.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "podcast")
public class PodcastModel extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "itunes_id", unique = true)
    private String itunesId;

    @NotNull
    private String name;

//    @ManyToMany(
//            fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            },
//            mappedBy = "podcasts")
//    @ManyToMany
//    @JoinTable(
//            name = "user_podcast",
//            joinColumns = @JoinColumn(name = "podcast_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//            Set<User> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItunesId() {
        return itunesId;
    }

    public void setItunesId(String itunesId) {
        this.itunesId = itunesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Podcast podcast = (Podcast) o;
//        return id == podcast.id &&
//                itunesId.equals(podcast.itunesId) &&
//                name.equals(podcast.name) &&
//                Objects.equals(users, podcast.users);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, itunesId, name, users);
//    }
//
//    @Override
//    public String toString() {
//        return "Podcast{" +
//                "id=" + id +
//                ", itunesId='" + itunesId + '\'' +
//                ", name='" + name + '\'' +
//                ", users=" + users +
//                '}';
//    }
}
