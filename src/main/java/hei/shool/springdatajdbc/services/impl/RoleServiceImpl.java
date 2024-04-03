package hei.shool.springdatajdbc.services.impl;

import hei.shool.springdatajdbc.entities.Role;
import hei.shool.springdatajdbc.repositories.RoleRepository;
import hei.shool.springdatajdbc.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private  final  RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
