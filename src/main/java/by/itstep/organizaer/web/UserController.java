package by.itstep.organizaer.web;

import by.itstep.organizaer.model.Contacts;
import by.itstep.organizaer.model.Friend;
import by.itstep.organizaer.model.User;
import by.itstep.organizaer.model.dto.UserDto;
import by.itstep.organizaer.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;
    @PostMapping("/create")
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
    }
    @GetMapping("/getUser")
    public ResponseEntity<List<UserDto>> getUser(){
        return  ResponseEntity.ok().body(userService.getUser());
    }
    @GetMapping("/getFriendByUserId,")
    public ResponseEntity<List<Friend>> getFriendByUserId(@RequestParam long userId){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.getFriendByUserId(userId));
    }
    @GetMapping("/getUserContacts,")
    public ResponseEntity<Map<User, Contacts>> getUserContacts(){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.getUserContacts());
    }
    @GetMapping("/getFriendContactsByUserId,")
    public ResponseEntity<Map<Friend,Contacts>> getFriendContactsByUserId(@RequestParam long userId){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.getFriendContactsByUserId(userId));
    }
}
