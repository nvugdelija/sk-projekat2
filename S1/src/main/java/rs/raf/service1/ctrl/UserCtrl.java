package rs.raf.service1.ctrl;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rs.raf.service1.domain.dto.UserReqDto;
import rs.raf.service1.domain.dto.UserResDto;
import rs.raf.service1.service.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class UserCtrl {

    private final UserService userService;

    @GetMapping("/findAll")
    public List<UserResDto> findAll() {
        return userService.findAll();
    }

    @PostMapping("/save")
    public UserResDto save(@Validated @RequestBody UserReqDto userReq) {
        return userService.save(userReq);
    }

}
