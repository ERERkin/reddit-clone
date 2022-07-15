package kg.erkin.springbackend.model.dto;

import kg.erkin.springbackend.model.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubredditDto implements BaseDto {
    private Long id;
    private String name;
    private String description;
    private List<PostDto> posts;
    private Instant createdDate;
    private UserDto user;
}
