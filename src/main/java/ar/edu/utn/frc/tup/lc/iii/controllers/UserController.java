package ar.edu.utn.frc.tup.lc.iii.controllers;

import ar.edu.utn.frc.tup.lc.iii.dtos.UserDto;
import ar.edu.utn.frc.tup.lc.iii.models.MatchDifficulty;
import ar.edu.utn.frc.tup.lc.iii.models.User;
import ar.edu.utn.frc.tup.lc.iii.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guess-number/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        User lUser = userService.createUser(userDto.getUserName(), userDto.getEmail());
        UserDto lUserDtoCreated = modelMapper.map(lUser, UserDto.class);
        return ResponseEntity.ok(lUserDtoCreated);
    }

    @PostMapping("/{userId}/matches")
    public ResponseEntity<UserDto> createUserMatch(@RequestBody MatchDifficulty matchDifficulty) {

        return ResponseEntity.ok(null);
    }













}
