package voe.company.OutfitsCompletedOfLog.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import voe.company.OutfitsCompletedOfLog.security.entity.UserEntity;
import voe.company.OutfitsCompletedOfLog.security.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/createForm")
    public String getFormFromCreate(){
        return "securityRegistration";
    }

    @PostMapping("/create")
    public String create(@RequestParam String name,
                         @RequestParam String role,
                         @RequestParam String password){
        UserEntity entity = new UserEntity(name, role, password);
        userService.addUser(entity);
        return "redirect:/createForm";
    }
}
