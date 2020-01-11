package rs.raf.service1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.raf.service1.dao.UserDao;
import rs.raf.service1.domain.User;
import rs.raf.service1.domain.dto.LoginDto;
import rs.raf.service1.domain.dto.UserResDto;
import rs.raf.service1.service.AuthService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserDao userDao;

    @Override
    public UserResDto login(LoginDto loginDto) {
        Optional<User> optUser = userDao.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        if(!optUser.isPresent()) {
            throw new RuntimeException("Email or password not correct");
        }
        return new UserResDto(optUser.get());
    }

}
