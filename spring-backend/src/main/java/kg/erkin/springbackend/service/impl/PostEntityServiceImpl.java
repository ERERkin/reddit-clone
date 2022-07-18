package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.Subreddit;
import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.repostitory.PostRepository;
import kg.erkin.springbackend.service.PostEntityService;
import kg.erkin.springbackend.service.base.AbstractEntityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostEntityServiceImpl extends AbstractEntityService<Post, PostRepository>
        implements PostEntityService {
    public PostEntityServiceImpl(PostRepository repository) {
        super(repository);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Post> getAllPostsBySubreddit(Subreddit subreddit) {
        return repository.findAllBySubreddit(subreddit);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Post> getAllPostsByUser(User user) {
        return repository.findAllByUser(user);
    }
}
