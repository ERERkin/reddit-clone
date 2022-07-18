package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.transferDtoToEntity.SubredditDtoToSubredditTransfer;
import kg.erkin.springbackend.mapper.transferEntityToDto.SubredditToSubredditDtoTransfer;
import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.entity.Subreddit;
import kg.erkin.springbackend.repostitory.SubredditRepository;
import kg.erkin.springbackend.service.SubredditService;
import kg.erkin.springbackend.service.base.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class SubredditServiceImpl extends AbstractService<Subreddit, SubredditDto, SubredditRepository,
        SubredditToSubredditDtoTransfer, SubredditDtoToSubredditTransfer>
        implements SubredditService {
    public SubredditServiceImpl(SubredditRepository repository, SubredditToSubredditDtoTransfer transferEntityToDto, SubredditDtoToSubredditTransfer transferDtoToEntity) {
        super(repository, transferEntityToDto, transferDtoToEntity);
    }

    @Override
    public SubredditDto getByName(String name) {
        Subreddit subreddit = repository.findByName(name).orElse(null);
        return subreddit == null ? null : transferEntityToDto.transferToDto(subreddit);
    }
}
