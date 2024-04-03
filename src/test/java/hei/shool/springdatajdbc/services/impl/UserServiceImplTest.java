package hei.shool.springdatajdbc.services.impl;

import hei.shool.springdatajdbc.dtos.UserDTO;
import hei.shool.springdatajdbc.entities.User;
import hei.shool.springdatajdbc.repositories.UserRepository;
import hei.shool.springdatajdbc.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setUsername("TEST DATA");
        user.setPassword("PASSWORD DELETE DATA");
        userRepository.save(user);
    }

    @Test
    void testGetAllUsers() {
        List<UserDTO> actualUsers = userService.getAllUsers();
        assertThat(actualUsers).isNotNull().isNotEmpty();
    }

    @Test
    void testSaveUser() {
        UserDTO toCreated = userService.saveUser(user);
        assertThat(toCreated).isNotNull();
        assertThat(toCreated.id()).isNotNull();
        assertThat(toCreated.username()).isEqualTo(user.getUsername());
        assertThat(toCreated.password()).isEqualTo(user.getPassword());
    }

    @Test
    void testGetUserByUsernameContaining() {
        List<UserDTO> users = userService.getUserByUsernameContaining("test");
        assertThat(users).isNotNull();
        assertThat(users).isNotEmpty();
        assertThat(users).extracting(UserDTO::id).contains(user.getId());
    }

    @Test
    void testDeleteById() {
        Optional<User> findUser = userRepository.findById(user.getId());
        assertThat(findUser).isPresent();
        UserDTO userDTO = userService.deleteById(user.getId());
        Optional<User> deletedUser = userRepository.findById(userDTO.id());
        assertThat(deletedUser).isEmpty();
    }

    @AfterEach
    void tearDown() {
        if (user != null) {
            userRepository.deleteById(user.getId());
        }
    }
}
