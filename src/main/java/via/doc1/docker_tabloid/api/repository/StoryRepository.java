package via.doc1.docker_tabloid.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import via.doc1.docker_tabloid.api.model.Story;

public interface StoryRepository extends JpaRepository<Story, String> {

}
