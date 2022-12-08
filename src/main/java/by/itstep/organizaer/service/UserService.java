package by.itstep.organizaer.service;

import by.itstep.organizaer.exceptions.UserAlreadyExistsException;
import by.itstep.organizaer.model.Contacts;
import by.itstep.organizaer.model.Friend;
import by.itstep.organizaer.model.User;
import by.itstep.organizaer.model.dto.UserDto;
import by.itstep.organizaer.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;
    public UserDto createUser(UserDto user){
        User userToSave = User.builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .birthDay(user.getBirthDay())
                .contacts(user.getContacts())
                .friendList(user.getFriendList())
                .build();
        User savedUser = userRepository.save(userToSave);
        return UserDto.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .login(savedUser.getLogin())
                .birthDay(savedUser.getBirthDay())
                .contacts(savedUser.getContacts())
                .friendList(savedUser.getFriendList())
                .build();
    }


    public List<UserDto> getUser() {
        List<User> list = userRepository.findAll();
        List<UserDto> dtoList  = new ArrayList<>();
        for (User elem: list) {
            dtoList.add(UserDto.builder()
                    .id(elem.getId())
                    .name(elem.getName())
                    .login(elem.getLogin())
                    .birthDay(elem.getBirthDay())
                    .contacts(elem.getContacts())
                    .friendList(elem.getFriendList())
                    .build());
        }
        return dtoList;
    }

}