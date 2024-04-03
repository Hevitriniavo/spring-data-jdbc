package hei.shool.springdatajdbc.services.impl;

import hei.shool.springdatajdbc.dtos.RoleDTO;
import hei.shool.springdatajdbc.dtos.UserDTO;
import hei.shool.springdatajdbc.entities.User;
import hei.shool.springdatajdbc.repositories.RoleRepository;
import hei.shool.springdatajdbc.repositories.UserRepository;
import hei.shool.springdatajdbc.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<UserDTO> getAllUsers() {
        final var users = userRepository.findAll();
        return users.stream()
                .map(this::convertToUserDTO)
                .collect(Collectors.toList());
    }


    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    private UserDTO convertToUserDTO(User user) {
        RoleDTO roleDTO = null;
        if (user.getRole() != null && user.getRole().getId() != null) {
            final var role = roleRepository
                    .findById(user.getRole().getId())
                    .orElse(null);
            if (role != null) {
                roleDTO = new RoleDTO(role.getId(), role.getName());
            }
        }
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), roleDTO);
    }
}
