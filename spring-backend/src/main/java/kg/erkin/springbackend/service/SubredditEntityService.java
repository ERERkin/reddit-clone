package kg.erkin.springbackend.service;

import kg.erkin.springbackend.model.entity.Subreddit;
import kg.erkin.springbackend.service.base.BaseEntityService;

public interface SubredditEntityService extends BaseEntityService<Subreddit> {
    Subreddit getByName(String name);
}
