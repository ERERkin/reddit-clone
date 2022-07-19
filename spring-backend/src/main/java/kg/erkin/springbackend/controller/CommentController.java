package kg.erkin.springbackend.controller;

import kg.erkin.springbackend.model.dto.CommentDto;
import kg.erkin.springbackend.model.dto.api.CommentRequest;
import kg.erkin.springbackend.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static javax.security.auth.callback.ConfirmationCallback.OK;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/comments/")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<?> createComment(@RequestBody CommentRequest commentRequest) {
        commentService.save(commentRequest);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping("/by-post/{postId}")
    public ResponseEntity<?> getAllCommentsForPost(@PathVariable Long postId) {
        return ResponseEntity.status(OK)
                .body(commentService.getResponseListByPostId(postId));
    }

    @GetMapping("/by-user/{userName}")
    public ResponseEntity<?> getAllCommentsForUser(@PathVariable String userName){
        return ResponseEntity.status(OK)
                .body(commentService.getResponseListByUserUsername(userName));
    }
}
