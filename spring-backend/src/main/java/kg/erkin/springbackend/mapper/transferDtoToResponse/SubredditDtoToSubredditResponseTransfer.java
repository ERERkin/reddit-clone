package kg.erkin.springbackend.mapper.transferDtoToResponse;

import kg.erkin.springbackend.mapper.transferDtoToResponse.base.AbstractTransferDtoToResponse;
import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.dto.api.SubredditResponse;
import org.springframework.stereotype.Component;

@Component
public class SubredditDtoToSubredditResponseTransfer
        extends AbstractTransferDtoToResponse<SubredditDto, SubredditResponse> {

    @Override
    public SubredditResponse transferToResponse(SubredditDto dto) {
        return SubredditResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .numberOfPosts(dto.getPosts().size())
                .build();
    }
}
