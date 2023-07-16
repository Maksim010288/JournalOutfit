package voe.company.OutfitsCompletedOfLog.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voe.company.OutfitsCompletedOfLog.security.entity.UserEntity;
import voe.company.OutfitsCompletedOfLog.security.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity addUser(UserEntity entity) {
        UserEntity userEntity = new UserEntity(
                entity.getUserName(),
                entity.getRole(),
                entity.getPassword()
        );
        return userRepository.save(userEntity);
    }
}
