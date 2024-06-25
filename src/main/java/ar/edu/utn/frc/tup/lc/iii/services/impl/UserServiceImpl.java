package ar.edu.utn.frc.tup.lc.iii.services.impl;

import ar.edu.utn.frc.tup.lc.iii.entities.UserEntity;
import ar.edu.utn.frc.tup.lc.iii.models.Match;
import ar.edu.utn.frc.tup.lc.iii.models.MatchDifficulty;
import ar.edu.utn.frc.tup.lc.iii.models.User;
import ar.edu.utn.frc.tup.lc.iii.repositories.UserRepository;
import ar.edu.utn.frc.tup.lc.iii.services.MatchService;
import ar.edu.utn.frc.tup.lc.iii.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository oUserRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MatchService matchService;

    @Override
    public User createUser(String userName, String email) {
        Optional <UserEntity> lUserEntityOptional = oUserRepository.getByEmail(email);

        if (lUserEntityOptional.isPresent()) {
            // TODO: Enviar error al usuario.
            return null;
        }
        else{
            UserEntity lUserEntity = new UserEntity();
            lUserEntity.setUserName(userName);
            lUserEntity.setEmail(email);
            UserEntity lUserEntitySaved = oUserRepository.save(lUserEntity);
            return modelMapper.map(lUserEntitySaved, User.class);
        }
    }

    @Override
    public Match createUserMatch(Long userId, MatchDifficulty matchDifficulty) {
        Optional<UserEntity> userEntity = oUserRepository.findById(userId);
        if(userEntity.isEmpty()){
            throw new EntityNotFoundException();
        } else {
            User user = modelMapper.map(userEntity.get(), User.class);
            return matchService.createMatch(user, matchDifficulty);
        }
    }


}
