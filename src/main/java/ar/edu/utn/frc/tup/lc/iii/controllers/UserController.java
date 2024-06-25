package ar.edu.utn.frc.tup.lc.iii.controllers;

import ar.edu.utn.frc.tup.lc.iii.dtos.MatchDto;
import ar.edu.utn.frc.tup.lc.iii.dtos.UserDto;
import ar.edu.utn.frc.tup.lc.iii.models.Match;
import ar.edu.utn.frc.tup.lc.iii.models.MatchDifficulty;
import ar.edu.utn.frc.tup.lc.iii.models.User;
import ar.edu.utn.frc.tup.lc.iii.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{userId}/matches/{matchDifficulty}")
    public ResponseEntity<UserDto> createUserMatch(@PathVariable Long userId,
                                                   @PathVariable MatchDifficulty matchDifficulty) {

        Match match = userService.createUserMatch(userId, matchDifficulty);
        MatchDto matchDto = modelMapper.map(match, MatchDto.class);
        return ResponseEntity.ok(null);
    }













}
