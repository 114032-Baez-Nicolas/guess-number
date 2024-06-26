package ar.edu.utn.frc.tup.lc.iii.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {

    private Long id;

    @JsonProperty("username")
    private String userName;

    @Email(message = "Email should be valid")
    private String email;

}
