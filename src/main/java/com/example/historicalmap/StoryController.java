package com.example.historicalmap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller to handle web requests for historical stories.
 */
@RestController
@RequestMapping("/api/stories")
@CrossOrigin(origins = "*")
public class StoryController {

    private final StoryRepository storyRepository;

    @Autowired
    public StoryController(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @GetMapping
    public List<Story> getAllStories() {
        return storyRepository.findAll();
    }

    @PostMapping
    public Story createStory(@RequestBody Story story) {
        return storyRepository.save(story);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStory(@PathVariable String id) {
        storyRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // --- NEW EDIT/UPDATE ENDPOINT ---
    /**
     * Updates an existing story.
     * @param id The ID of the story to update.
     * @param updatedStory The story object with the new data.
     * @return The updated story object or a 404 Not Found response.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Story> updateStory(@PathVariable String id, @RequestBody Story updatedStory) {
        Optional<Story> existingStoryOptional = storyRepository.findById(id);
        
        if (existingStoryOptional.isPresent()) {
            Story existingStory = existingStoryOptional.get();
            existingStory.setTitle(updatedStory.getTitle());
            existingStory.setDescription(updatedStory.getDescription());
            existingStory.setEra(updatedStory.getEra());
            // Note: Latitude and Longitude are not updated as the location is fixed.
            final Story savedStory = storyRepository.save(existingStory);
            return ResponseEntity.ok(savedStory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

