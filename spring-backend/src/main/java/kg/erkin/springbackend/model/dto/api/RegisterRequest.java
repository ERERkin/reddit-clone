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
public class RegisterRequest implements BaseRequest {
    private String email;
    private String username;
    private String password;
}
