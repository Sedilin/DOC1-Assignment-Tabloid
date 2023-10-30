package via.doc1.docker_tabloid.persistance.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import via.doc1.docker_tabloid.api.model.Story;
import via.doc1.docker_tabloid.api.repository.StoryRepository;
import via.doc1.docker_tabloid.persistance.IService.IStoryService;

import java.util.List;

@Service
public class StoryService implements IStoryService {

    @Autowired
    StoryRepository storyRepository;
    @Override
    public Story addStory(Story story) {
        return storyRepository.save(story);
    }

    @Override
    public List<Story> getAllStories() {
        return storyRepository.findAll();
    }

    @Override
    public Story updateStory(int StoryId, Story story) {
        if (storyRepository.findById(String.valueOf(StoryId)).isPresent()) {
            story.setId(StoryId);
            storyRepository.save(story);
        }
        return story;
    }

    @Override
    public boolean removeStory(int StoryId) {
        if (storyRepository.findById(String.valueOf(StoryId)).isPresent())
        {
            storyRepository.deleteById(String.valueOf(StoryId));
            return true;
        }
        return false;
    }
}
