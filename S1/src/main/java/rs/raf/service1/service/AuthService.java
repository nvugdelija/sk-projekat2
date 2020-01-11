package rs.raf.service1.service;

import rs.raf.service1.domain.dto.LoginDto;
import rs.raf.service1.domain.dto.UserResDto;

public interface AuthService {

    UserResDto login(LoginDto loginDto);

}
