package kg.erkin.springbackend.mapper.transferRequestToDto;

import kg.erkin.springbackend.mapper.transferRequestToDto.base.AbstractTransferRequestToDto;
import kg.erkin.springbackend.model.dto.SubredditDto;
import kg.erkin.springbackend.model.dto.api.SubredditRequest;
import kg.erkin.springbackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubredditRequestToSubredditDtoTransfer
        extends AbstractTransferRequestToDto<SubredditDto, SubredditRequest> {
    @Autowired
    private AuthService authService;

    @Override
    public SubredditDto transferToDto(SubredditRequest request) {
        return SubredditDto.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .user(authService.getCurrentUser())
                .build();
    }
}
