package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.TransferDtoToEntity.SubredditDtoToSubredditTransfer;
import kg.erkin.springbackend.mapper.TransferEntityToDto.SubredditToSubredditDtoTransfer;
import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.entity.Subreddit;
import kg.erkin.springbackend.repostitory.SubredditRepository;
import kg.erkin.springbackend.service.SubredditService;
import kg.erkin.springbackend.service.base.AbstractService;
import kg.erkin.springbackend.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class SubredditServiceImpl extends AbstractService<Subreddit, SubredditDto, SubredditRepository,
        SubredditToSubredditDtoTransfer, SubredditDtoToSubredditTransfer>
        implements SubredditService {
    public SubredditServiceImpl(SubredditRepository repository, SubredditToSubredditDtoTransfer transferEntityToDto, SubredditDtoToSubredditTransfer transferDtoToEntity) {
        super(repository, transferEntityToDto, transferDtoToEntity);
    }
}
