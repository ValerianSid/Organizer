package by.itstep.organizaer.service;

import by.itstep.organizaer.exceptions.UserAlreadyExistsException;
import by.itstep.organizaer.model.Friend;
import by.itstep.organizaer.repository.FriendRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FriendService {
    FriendRepository friendRepository;

    public Friend createFriend(Friend friend) {
        if(friendRepository.exists(Example.of(friend))){
            throw  new UserAlreadyExistsException("Друг уже существует");
        }
        return friendRepository.save(friend);
    }


}