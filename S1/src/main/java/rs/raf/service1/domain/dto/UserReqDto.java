package rs.raf.service1.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Data
public class UserReqDto {

    private String firstName;

    private String lastName;

    @Email
    private String email;

    @Length(min = 4, max = 16)
    private String password;

}
