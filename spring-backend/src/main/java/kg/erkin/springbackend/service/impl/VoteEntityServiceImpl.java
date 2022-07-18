package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.model.entity.Vote;
import kg.erkin.springbackend.repostitory.VoteRepository;
import kg.erkin.springbackend.service.VoteEntityService;
import kg.erkin.springbackend.service.base.AbstractEntityService;
import org.springframework.stereotype.Service;

@Service
public class VoteEntityServiceImpl extends AbstractEntityService<Vote, VoteRepository>
        implements VoteEntityService {
    public VoteEntityServiceImpl(VoteRepository repository) {
        super(repository);
    }

    @Override
    public Vote getTopByPostAndUserOrderByVoteIdDesc(Post post, User user) {
        return repository.findTopByPostAndUserOrderByVoteIdDesc(post, user).orElse(null);
    }
}
