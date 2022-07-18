package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.model.entity.Subreddit;
import kg.erkin.springbackend.repostitory.SubredditRepository;
import kg.erkin.springbackend.service.SubredditEntityService;
import kg.erkin.springbackend.service.base.AbstractEntityService;
import org.springframework.stereotype.Service;

@Service
public class SubredditEntityServiceImpl extends AbstractEntityService<Subreddit, SubredditRepository>
        implements SubredditEntityService {
    public SubredditEntityServiceImpl(SubredditRepository repository) {
        super(repository);
    }
}
