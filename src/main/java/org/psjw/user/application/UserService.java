package org.psjw.user.application;

import java.util.IllformedLocaleException;
import org.psjw.user.application.dto.CreatedUserRequestDto;
import org.psjw.user.application.interfaces.UserRepository;
import org.psjw.user.domain.User;
import org.psjw.user.domain.UserInfo;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User createUser(CreatedUserRequestDto dto) {
        UserInfo info = new UserInfo(dto.name(), dto.profileImageUrl());
        User user = new User(null, info);
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(IllformedLocaleException::new);
    }
}
