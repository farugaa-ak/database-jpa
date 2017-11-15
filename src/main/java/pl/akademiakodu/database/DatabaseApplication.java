package pl.akademiakodu.database;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.akademiakodu.database.model.onetomany.Product;
import pl.akademiakodu.database.model.onetomany.ShoppingCart;
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

			ShoppingCart koszyk1 = buildShoppingCartWithProducts("koszyk1", "mleko", "chleb", "maslo");
			ShoppingCart koszyk2 = buildShoppingCartWithProducts("koszyk2", "bmw", "audi", "masertti");

			shoppingCartService.save(koszyk1);
			shoppingCartService.save(koszyk2);




		});
	}

	private ShoppingCart buildShoppingCartWithProducts(String koszyk11, String product1Name, String product2Name, String product3Name) {
		ShoppingCart koszyk1 = new ShoppingCart(koszyk11);

		Product mleko = new Product(product1Name, koszyk1);
		Product chleb = new Product(product2Name, koszyk1);
		Product maslo =  new Product(product3Name, koszyk1);

		List<Product> products =new ArrayList<>();
		products.add(mleko);
		products.add(chleb);
		products.add(maslo);

		koszyk1.setProducts(products);
		return koszyk1;
	}

}
