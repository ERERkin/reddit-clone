package kg.erkin.springbackend.model.dto.api;

import kg.erkin.springbackend.model.dto.api.base.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubredditRequest implements BaseRequest {
    private Long id;
    private String name;
    private String description;
}
