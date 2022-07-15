package kg.erkin.springbackend.model.dto;

import kg.erkin.springbackend.model.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto implements BaseDto {
    private Long postId;
    private String postName;
    private String url;
    private String description;
    private Integer voteCount;
    private UserDto user;
    private Instant createdDate;
    private SubredditDto subreddit;
}
