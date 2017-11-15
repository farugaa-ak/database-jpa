package pl.akademiakodu.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.akademiakodu.database.model.onetomany.Product;
import pl.akademiakodu.database.model.onetomany.ShoppingCart;
import pl.akademiakodu.database.repository.ShoppingCartRepository;
import pl.akademiakodu.database.service.ProductService;
import pl.akademiakodu.database.service.ShoppingCartService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}


	@Bean
	public CommandLineRunner runWithDb(ShoppingCartService shoppingCartService, ProductService productService){
		return (args -> {

			ShoppingCart koszyk1 = new ShoppingCart("koszyk1");

			Product mleko = new Product("mleko", koszyk1);
			Product chleb = new Product("chleb", koszyk1);
			Product maslo =  new Product("maslo", koszyk1);

			List<Product> products =new ArrayList<>();
			products.add(mleko);
			products.add(chleb);
			products.add(maslo);

			koszyk1.setProducts(products);

			shoppingCartService.save(koszyk1);
			/*productService.save(mleko);
			productService.save(chleb);
			productService.save(maslo);*/



		});
	}

}
