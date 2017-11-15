package pl.akademiakodu.database.repository;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.database.model.manytomany.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
}
