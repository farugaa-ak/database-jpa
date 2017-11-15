package pl.akademiakodu.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.akademiakodu.database.model.onetomany.ShoppingCart;
import pl.akademiakodu.database.repository.ShoppingCartRepository;
import pl.akademiakodu.database.service.ProductService;
import pl.akademiakodu.database.service.ShoppingCartService;

@SpringBootApplication
public class DatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}


	@Bean
	public CommandLineRunner runWithDb(ShoppingCartService shoppingCartService, ProductService productService){
		return (args -> {

			ShoppingCart koszyk1 = new ShoppingCart("koszyk1");




		});
	}

}
