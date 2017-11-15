package pl.akademiakodu.database.repository;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.database.model.onetoone.User;

public interface UserRepository extends CrudRepository<User, Long>{
}
