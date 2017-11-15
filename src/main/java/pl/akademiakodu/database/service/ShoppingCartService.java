package pl.akademiakodu.database.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.database.model.onetomany.ShoppingCart;
import pl.akademiakodu.database.repository.ShoppingCartRepository;

import java.util.Collection;

@Service
public class ShoppingCartService {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    public void save(ShoppingCart  shoppingCart){
        shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart find(Long id){
        return shoppingCartRepository.findOne(id);
    }

    public Collection<ShoppingCart> findAll(){
        return shoppingCartRepository.findAll();
    }


}
