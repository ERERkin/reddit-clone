package kg.erkin.springbackend.controller;

import kg.erkin.springbackend.model.dto.api.PostRequest;
import kg.erkin.springbackend.model.dto.api.PostResponse;
import kg.erkin.springbackend.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts/")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest) {
        postService.saveRequest(postRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getResponseById(id));
    }

    @GetMapping("by-subreddit/{id}")
    public ResponseEntity<?> getPostsBySubreddit(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostResponsesBySubreddit(id));
    }

    @GetMapping("by-user/{name}")
    public ResponseEntity<?> getPostsByUsername(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostResponsesByUsername(name));
    }
}
