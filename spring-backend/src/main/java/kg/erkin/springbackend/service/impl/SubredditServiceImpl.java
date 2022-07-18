package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.transferDtoToEntity.SubredditDtoToSubredditTransfer;
import kg.erkin.springbackend.mapper.transferEntityToDto.SubredditToSubredditDtoTransfer;
import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.entity.Subreddit;
import kg.erkin.springbackend.service.SubredditEntityService;
import kg.erkin.springbackend.service.SubredditService;
import kg.erkin.springbackend.service.base.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class SubredditServiceImpl extends AbstractService<SubredditEntityService, Subreddit, SubredditDto,
        SubredditToSubredditDtoTransfer, SubredditDtoToSubredditTransfer>
        implements SubredditService {

    public SubredditServiceImpl(SubredditEntityService entityService, SubredditToSubredditDtoTransfer transferToDto, SubredditDtoToSubredditTransfer transferToEntity) {
        super(entityService, transferToDto, transferToEntity);
    }

    @Override
    public SubredditDto getByName(String name) {
        Subreddit subreddit = entityService.getByName(name);
        return subreddit == null ? null : transferEntityToDto.transferToDto(subreddit);
    }
}
