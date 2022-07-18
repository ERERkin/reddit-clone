package kg.erkin.springbackend.model.dto.api;

import kg.erkin.springbackend.model.dto.api.base.BaseRequest;
import kg.erkin.springbackend.model.enums.VoteType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoteRequest implements BaseRequest {
    private VoteType voteType;
    private Long postId;
}
