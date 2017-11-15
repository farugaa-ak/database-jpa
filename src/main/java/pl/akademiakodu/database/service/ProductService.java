package pl.akademiakodu.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.database.model.onetomany.Product;
import pl.akademiakodu.database.repository.ProductRepository;

import java.util.Collection;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void save(Product product){
        productRepository.save(product);
    }

    public Collection<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findOne(Long id){
        return productRepository.findOne(id);
    }

}
