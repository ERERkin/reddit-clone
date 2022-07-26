package kg.erkin.springbackend.controller;

import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.dto.api.SubredditRequest;
import kg.erkin.springbackend.service.SubredditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subreddit")
public class SubredditController {
    @Autowired
    private SubredditService subredditService;

    @PostMapping
    public ResponseEntity<?> createSubreddit(@RequestBody SubredditRequest subredditRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subredditService.save(subredditRequest));
    }

    @GetMapping
    public ResponseEntity<?> getAllSubreddits() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(subredditService.getResponseList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubreddit(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(subredditService.getResponseById(id));
    }
}
