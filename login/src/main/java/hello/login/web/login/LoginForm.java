package hello.login.web.login;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginForm {

    @NotEmpty
    public String loginId;

    @NotEmpty
    public String password;

}
