package voe.company.OutfitsCompletedOfLog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import voe.company.OutfitsCompletedOfLog.entity.UsersEntity;
import voe.company.OutfitsCompletedOfLog.repository.UserRepository;

@Service
public class UserDetService implements UserDetailsService {

   private UsersEntity users;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserDetService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        this.users = findByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserMagazineDetails(users);
    }

    private UsersEntity findByUsername(String userName) {
        for (UsersEntity entity : userRepository.findAll()) {
            if (entity.getEmail().equals(userName)) {
                return entity;
            }
        }
        return null;
    }

    public UsersEntity getUsers() {
        return users;
    }
}
