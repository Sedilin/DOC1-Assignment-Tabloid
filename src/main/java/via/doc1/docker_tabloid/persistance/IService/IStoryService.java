package via.doc1.docker_tabloid.persistance.IService;

import org.springframework.stereotype.Service;
import via.doc1.docker_tabloid.api.model.Story;

import java.util.List;

@Service
public interface IStoryService {
    Story addStory(Story story);
    List<Story> getAllStories();
    Story updateStory(int StoryId, Story story);
    boolean removeStory(int StoryId);
}
