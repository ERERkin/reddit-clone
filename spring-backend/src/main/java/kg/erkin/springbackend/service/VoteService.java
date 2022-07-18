package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.dto.VoteDto;
import kg.erkin.springbackend.model.dto.api.VoteRequest;
import kg.erkin.springbackend.service.base.BaseService;

public interface VoteService extends BaseService<VoteDto> {
    void vote(VoteRequest voteRequest);
}
