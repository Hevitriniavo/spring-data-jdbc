package hei.shool.springdatajdbc.controllers;

import hei.shool.springdatajdbc.entities.Role;
import hei.shool.springdatajdbc.services.RoleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
}
