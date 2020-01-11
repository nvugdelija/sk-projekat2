package rs.raf.service1.ctrl;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rs.raf.service1.domain.dto.LoginDto;
import rs.raf.service1.domain.dto.UserResDto;
import rs.raf.service1.service.AuthService;
import rs.raf.service1.service.TokenHandlerService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class AuthCtrl {

    private final AuthService authService;

    private final TokenHandlerService tokenHandlerService;

    @PostMapping("/login")
    public UserResDto login(@Validated @RequestBody LoginDto loginDto) {
        return authService.login(loginDto);
    }

    @GetMapping("/getToken")
    public String getToken(String email) {
        return tokenHandlerService.getTokenByEmail(email);
    }

    @GetMapping("/getEmail")
    public String getEmail(HttpServletRequest request) {
        String token = request.getHeader("AUTH");
        System.out.println("TOkEN: "+token);
        return tokenHandlerService.getEmailByToken(token);
    }

}
