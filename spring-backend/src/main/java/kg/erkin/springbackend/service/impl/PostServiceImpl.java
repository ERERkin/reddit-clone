package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.TransferDtoToEntity.PostDtoToPostTransfer;
import kg.erkin.springbackend.mapper.TransferEntityToDto.PostToPostDtoTransfer;
import kg.erkin.springbackend.model.dto.PostDto;
import kg.erkin.springbackend.model.entity.Post;
import kg.erkin.springbackend.repostitory.PostRepository;
import kg.erkin.springbackend.service.PostService;
import kg.erkin.springbackend.service.base.AbstractService;
import kg.erkin.springbackend.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends AbstractService<Post, PostDto, PostRepository,
        PostToPostDtoTransfer, PostDtoToPostTransfer>
        implements PostService {
    public PostServiceImpl(PostRepository repository, PostToPostDtoTransfer transferEntityToDto, PostDtoToPostTransfer transferDtoToEntity) {
        super(repository, transferEntityToDto, transferDtoToEntity);
    }
}
