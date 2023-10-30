package via.doc1.docker_tabloid.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import via.doc1.docker_tabloid.api.model.Story;
import via.doc1.docker_tabloid.persistance.IService.IStoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/story")
public class StoryController {

    private IStoryService storyService;

    @Autowired
    public StoryController(IStoryService storyService) {
        this.storyService = storyService;
    }

    @PostMapping
    public ResponseEntity<Story> addNewStory(@RequestBody Story story)
    {
        Optional<Story> success = Optional.of(storyService.addStory(story));
        if (success.isPresent())
        {
            return new ResponseEntity<>(success.get(), HttpStatus.OK);

        }
        else
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping()
    public ResponseEntity<List<Story>> getAllStories()
    {
        List<Story> success = storyService.getAllStories();
        if (success != null)
        {
            return new ResponseEntity<>(success, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Story> updateStory(@RequestParam int storyId, @RequestBody Story story)
    {
        Optional<Story> success = Optional.of(storyService.updateStory(storyId, story));
        if (success.isPresent())
        {
            return new ResponseEntity<>(success.get(), HttpStatus.OK);

        }
        else
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping()
    public ResponseEntity deleteAccount(@RequestParam int storyId)
    {
        boolean isCompleted = storyService.removeStory(storyId);
        if (isCompleted == true)
        {
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
