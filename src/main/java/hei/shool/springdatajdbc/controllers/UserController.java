package hei.shool.springdatajdbc.controllers;

import hei.shool.springdatajdbc.dtos.UserDTO;
import hei.shool.springdatajdbc.entities.User;
import hei.shool.springdatajdbc.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/search")
    public List<UserDTO> getUserByUsernameContaining(@RequestParam String username){
        return userService.getUserByUsernameContaining(username);
    }


    @PostMapping
    public UserDTO createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

}
