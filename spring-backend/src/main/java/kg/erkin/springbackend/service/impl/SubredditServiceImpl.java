package kg.erkin.springbackend.service.impl;

import kg.erkin.springbackend.mapper.transferDtoToEntity.SubredditDtoToSubredditTransfer;
import kg.erkin.springbackend.mapper.transferDtoToResponse.SubredditDtoToSubredditResponseTransfer;
import kg.erkin.springbackend.mapper.transferEntityToDto.SubredditToSubredditDtoTransfer;
import kg.erkin.springbackend.mapper.transferRequestToDto.SubredditRequestToSubredditDtoTransfer;
import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.dto.api.SubredditRequest;
import kg.erkin.springbackend.model.dto.api.SubredditResponse;
import kg.erkin.springbackend.model.entity.Subreddit;
import kg.erkin.springbackend.service.SubredditEntityService;
import kg.erkin.springbackend.service.SubredditService;
import kg.erkin.springbackend.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubredditServiceImpl extends AbstractService<SubredditEntityService, Subreddit, SubredditDto,
        SubredditToSubredditDtoTransfer, SubredditDtoToSubredditTransfer>
        implements SubredditService {
    @Autowired
    private SubredditRequestToSubredditDtoTransfer subredditRequestToSubredditDtoTransfer;
    @Autowired
    private SubredditDtoToSubredditResponseTransfer subredditDtoToSubredditResponseTransfer;

    public SubredditServiceImpl(SubredditEntityService entityService, SubredditToSubredditDtoTransfer transferToDto, SubredditDtoToSubredditTransfer transferToEntity) {
        super(entityService, transferToDto, transferToEntity);
    }

    @Override
    public SubredditDto getByName(String name) {
        Subreddit subreddit = entityService.getByName(name);
        return subreddit == null ? null : transferEntityToDto.transferToDto(subreddit);
    }

    @Override
    public SubredditResponse save(SubredditRequest subredditRequest) {
        SubredditDto subredditDto = subredditRequestToSubredditDtoTransfer.transferToDto(subredditRequest);
        subredditDto = save(subredditDto);
        return subredditDtoToSubredditResponseTransfer.transferToResponse(subredditDto);
    }

    @Override
    public List<SubredditResponse> getResponseList() {
        return subredditDtoToSubredditResponseTransfer.transferToResponseList(getAll());
    }

    @Override
    public SubredditResponse getResponseById(Long id) {
        return subredditDtoToSubredditResponseTransfer.transferToResponse(getById(id));
    }
}
