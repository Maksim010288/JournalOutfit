package voe.company.OutfitsCompletedOfLog.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import voe.company.OutfitsCompletedOfLog.entity.UsersEntity;

@Component
class UsersRoleServiceTest {

    @Autowired
    private UsersService roleService;

    @Test
    void checkUser() {
        UsersEntity entity = new UsersEntity("Demon@gmail.com", "demon", "ADMIN");
        Assertions.assertEquals(entity, roleService.createUser(entity));
    }
}