package org.psjw.user.application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.psjw.user.application.dto.CreateUserRequestDto;
import org.psjw.user.application.interfaces.UserRepository;
import org.psjw.user.domain.User;
import org.psjw.user.domain.UserInfo;
import org.psjw.user.repository.FakeUserRepository;

class UserServiceTest {

    private final UserRepository userRepository = new FakeUserRepository();
    //문제 : UserRepository 구현체 만들지 않음 -> stub, fake 객체를 통해 확인
    private UserService userService = new UserService(userRepository);

    @Test
    void givenUserInfoDto_whenCreateUser_thenCanFindUser() {
        //given
        CreateUserRequestDto dto = new CreateUserRequestDto("test", "");

        //when
        User savedUser = userService.createUser(dto);

        //then
        User foundUser = userService.getUser(savedUser.getId());
        UserInfo userInfo = foundUser.getUserInfo();
        assertEquals(foundUser.getId(), savedUser.getId());
        assertEquals("test", userInfo.getName());
    }

}