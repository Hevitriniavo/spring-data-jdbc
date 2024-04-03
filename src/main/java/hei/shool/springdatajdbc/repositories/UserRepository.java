package hei.shool.springdatajdbc.repositories;

import hei.shool.springdatajdbc.entities.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends ListCrudRepository<User, Integer> {
}
