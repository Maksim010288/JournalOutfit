package voe.company.OutfitsCompletedLog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import voe.company.OutfitsCompletedLog.entity.UsersEntity;
import voe.company.OutfitsCompletedLog.repository.UserRepository;

import java.util.Collection;


@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public UsersEntity createUser(UsersEntity usersEntity) {
        UsersEntity entity = new UsersEntity(
                usersEntity.getEmail(),
                passwordEncoder(usersEntity.getPassword()),
                usersEntity.getRole());
        return userRepository.save(entity);
    }

    public Collection<UsersEntity> getUsers(){
        return userRepository.findAll();
    }

    private String passwordEncoder(String pass) {
        return new BCryptPasswordEncoder().encode(pass);
    }

    public String checkUser(UsersEntity users) {
        for (UsersEntity usersEntity : userRepository.findAll()) {
            if (usersEntity.getEmail().equals(users.getEmail())) {
                return new RuntimeException("Such email exists").getMessage();
            }
        }
        return users.getEmail() + "create";
    }
}
