package voe.company.OutfitsCompletedOfLog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import voe.company.OutfitsCompletedOfLog.entity.UsersEntity;
import voe.company.OutfitsCompletedOfLog.repository.UserRepository;

@Service
public class UsersRoleService {

    @Autowired
    private UserRepository userRepository;

    public UsersEntity createNewUser(UsersEntity usersEntity) {
        UsersEntity entity = new UsersEntity(
                usersEntity.getEmail(),
                passwordEncoder(usersEntity.getPassword()),
                usersEntity.getRole());
        return userRepository.save(entity);
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
