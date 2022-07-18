package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.model.entity.Vote;
import kg.erkin.springbackend.service.base.BaseEntityService;

public interface VoteEntityService extends BaseEntityService<Vote> {
    Vote getTopByPostAndUserOrderByVoteIdDesc(Post post, User user);
}
