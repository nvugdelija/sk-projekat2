package rs.raf.service1.service;

import rs.raf.service1.domain.dto.UserReqDto;
import rs.raf.service1.domain.dto.UserResDto;

import java.util.List;

public interface UserService {

    List<UserResDto> findAll();

    UserResDto save(UserReqDto userReq);

}
