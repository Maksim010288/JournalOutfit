package voe.company.OutfitsCompletedOfLog.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import voe.company.OutfitsCompletedOfLog.entity.UsersEntity;
import voe.company.OutfitsCompletedOfLog.repository.UserRepository;

@Service
public class UsersRoleService {

    @Autowired
    private UserRepository userRepository;

    public UsersEntity createNewUser(UsersEntity usersEntity){
        return userRepository.save(usersEntity);
    }

//    public String passwordEncoder(String pass){
//        return new BCryptPasswordEncoder().encode(pass);
//    }

    public Integer idRole(String role){
        if (role.equals("ADMIN")){
            return 1;
        } else if (role.equals("USER")) {
            return 2;
        }
        return null;
    }

    public String checkUser(UsersEntity users){
        for (UsersEntity usersEntity : userRepository.findAll()){
            if (usersEntity.getEmail().equals(users.getEmail())){
                return new RuntimeException("Such email exists").getMessage();
            }
        }
        return userRepository.save(users).getEmail() + "create";
    }
}
