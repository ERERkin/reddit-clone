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
public class PostRequest implements BaseRequest {
    private Long postId;
    private String subredditName;
    private String postName;
    private String url;
    private String description;
}
