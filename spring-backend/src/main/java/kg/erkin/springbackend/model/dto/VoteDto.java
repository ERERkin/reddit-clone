package kg.erkin.springbackend.model.dto;

import kg.erkin.springbackend.model.dto.base.BaseDto;
import kg.erkin.springbackend.model.enums.VoteType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoteDto implements BaseDto {
    private Long voteId;
    private VoteType voteType;
    private PostDto post;
    private UserDto user;
}
