package pl.akademiakodu.database.repository;


import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.database.model.onetomany.ShoppingCart;

import java.util.Collection;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{

    Collection<ShoppingCart> findAll();
}
