package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.dto.api.SubredditRequest;
import kg.erkin.springbackend.model.dto.api.SubredditResponse;
import kg.erkin.springbackend.service.base.BaseService;

import java.util.List;

public interface SubredditService extends BaseService<SubredditDto> {
    SubredditDto getByName(String name);
    SubredditResponse save(SubredditRequest subredditRequest);
    List<SubredditResponse> getResponseList();
    SubredditResponse getResponseById(Long id);
}
