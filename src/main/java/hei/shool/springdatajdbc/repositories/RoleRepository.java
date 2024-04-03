package hei.shool.springdatajdbc.repositories;

import hei.shool.springdatajdbc.entities.Role;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends ListCrudRepository<Role, Long> {
}

