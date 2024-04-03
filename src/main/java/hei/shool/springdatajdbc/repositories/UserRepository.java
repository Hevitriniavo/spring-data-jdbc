package hei.shool.springdatajdbc.repositories;

import hei.shool.springdatajdbc.entities.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {
   List<User> findByUsernameIsContainingIgnoreCase(String username);
}
