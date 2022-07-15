package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.TransferDtoToEntity.CommentDtoToCommentTransfer;
import kg.erkin.springbackend.mapper.TransferEntityToDto.CommentToCommentDtoTransfer;
import kg.erkin.springbackend.model.dto.CommentDto;
import kg.erkin.springbackend.model.entity.Comment;
import kg.erkin.springbackend.repostitory.CommentRepository;
import kg.erkin.springbackend.service.CommentService;
import kg.erkin.springbackend.service.base.AbstractService;
import kg.erkin.springbackend.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends AbstractService<Comment, CommentDto, CommentRepository,
        CommentToCommentDtoTransfer, CommentDtoToCommentTransfer>
        implements CommentService {
    public CommentServiceImpl(CommentRepository repository, CommentToCommentDtoTransfer transferEntityToDto, CommentDtoToCommentTransfer transferDtoToEntity) {
        super(repository, transferEntityToDto, transferDtoToEntity);
    }
}
