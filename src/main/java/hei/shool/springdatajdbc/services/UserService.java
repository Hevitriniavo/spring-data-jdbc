package hei.shool.springdatajdbc.services;

import hei.shool.springdatajdbc.dtos.UserDTO;
import hei.shool.springdatajdbc.entities.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    User saveUser(User user);
    List<UserDTO> getUserByUsernameContaining(String username);

}
