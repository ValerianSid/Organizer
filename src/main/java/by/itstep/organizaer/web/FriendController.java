package by.itstep.organizaer.web;

import by.itstep.organizaer.model.Friend;
import by.itstep.organizaer.service.FriendService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/friend")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FriendController {
    FriendService service;

    @PostMapping("/create")
    public ResponseEntity<Friend> createFriend(@RequestBody Friend friend){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createFriend(friend));
    }

}