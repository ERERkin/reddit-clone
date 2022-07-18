package kg.erkin.springbackend.controller;

import kg.erkin.springbackend.model.dto.VoteDto;
import kg.erkin.springbackend.model.dto.api.VoteRequest;
import kg.erkin.springbackend.service.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/votes/")
public class VoteController {
    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    public ResponseEntity<?> vote(@RequestBody VoteRequest voteRequest) {
        voteService.vote(voteRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
