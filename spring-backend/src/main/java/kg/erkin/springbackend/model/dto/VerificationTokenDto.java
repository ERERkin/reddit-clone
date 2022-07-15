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
public class VerificationTokenDto implements BaseDto {
    private Long id;
    private String token;
    private UserDto user;
    private Instant expiryDate;
}
