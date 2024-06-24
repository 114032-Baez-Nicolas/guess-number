package ar.edu.utn.frc.tup.lc.iii.services;

import ar.edu.utn.frc.tup.lc.iii.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User createUser(String userName, String email);
}
