package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.model.entity.Comment;
import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.User;
import kg.erkin.springbackend.repostitory.CommentRepository;
import kg.erkin.springbackend.service.CommentEntityService;
import kg.erkin.springbackend.service.base.AbstractEntityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentEntityServiceImpl extends AbstractEntityService<Comment, CommentRepository>
        implements CommentEntityService {
    public CommentEntityServiceImpl(CommentRepository repository) {
        super(repository);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getAllByPost(Post post) {
        return repository.findAllByPost(post);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getAllByUser(User user) {
        return repository.findAllByUser(user);
    }
}
