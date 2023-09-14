package voe.company.OutfitsCompletedOfLog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import voe.company.OutfitsCompletedOfLog.entity.UsersEntity;
import voe.company.OutfitsCompletedOfLog.service.UsersRoleService;

@Controller
@RequestMapping("/")
public class RegistrationPersonController {

    @Autowired
    private UsersRoleService usersRoleService;

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("person/add")
    public String personRole(){
        return "registration";
    }

    @PostMapping("person/add")
    public String addPerson(@RequestParam String email,
                            @RequestParam String password,
                            @RequestParam String role,
                            Model model){
        UsersEntity entity = new UsersEntity(email, password, role);
        model.addAttribute("outInfo", usersRoleService.checkUser(entity));
        usersRoleService.createNewUser(entity);
        return "registration";
    }

    @GetMapping("person/getAllPerson")
    public String getAllUser(){
        return usersRoleService.getUsers().toString();
    }
}
