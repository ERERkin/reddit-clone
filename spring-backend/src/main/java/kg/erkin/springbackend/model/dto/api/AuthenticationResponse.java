package kg.erkin.springbackend.model.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {
    private String authenticationToken;
    private String refreshToken;
    private Instant expiresAt;
    private String username;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostRequest {
        private Long postId;
        private String subredditName;
        private String postName;
        private String url;
        private String description;
    }
}
