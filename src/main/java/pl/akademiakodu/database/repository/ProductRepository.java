package pl.akademiakodu.database.repository;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.database.model.onetomany.Product;

import java.util.Collection;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Collection<Product> findAll();
}
