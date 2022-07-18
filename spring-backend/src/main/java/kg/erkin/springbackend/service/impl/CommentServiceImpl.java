package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.transferDtoToEntity.CommentDtoToCommentTransfer;
import kg.erkin.springbackend.mapper.transferDtoToEntity.PostDtoToPostTransfer;
import kg.erkin.springbackend.mapper.transferEntityToDto.CommentToCommentDtoTransfer;
import kg.erkin.springbackend.model.dto.CommentDto;
import kg.erkin.springbackend.model.dto.PostDto;
import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.entity.Comment;
import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.model.entity.Subreddit;
import kg.erkin.springbackend.repostitory.CommentRepository;
import kg.erkin.springbackend.service.CommentService;
import kg.erkin.springbackend.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl extends AbstractService<Comment, CommentDto, CommentRepository,
        CommentToCommentDtoTransfer, CommentDtoToCommentTransfer>
        implements CommentService {
    public CommentServiceImpl(CommentRepository repository, CommentToCommentDtoTransfer transferEntityToDto, CommentDtoToCommentTransfer transferDtoToEntity) {
        super(repository, transferEntityToDto, transferDtoToEntity);
    }
    @Autowired
    private PostDtoToPostTransfer postDtoToPostTransfer;

    @Override
    public List<CommentDto> getAllByPost(PostDto postDto) {
        List<Comment> commentList = repository.findAllByPost(postDtoToPostTransfer.transferToEntity(postDto));
        return transferEntityToDto.transferToDtoList(commentList);
    }
}
