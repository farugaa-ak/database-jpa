package pl.akademiakodu.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.akademiakodu.database.model.manytomany.Employee;
import pl.akademiakodu.database.model.manytomany.Meeting;
import pl.akademiakodu.database.model.onetomany.Product;
import pl.akademiakodu.database.model.onetomany.ShoppingCart;
import pl.akademiakodu.database.model.onetoone.Address;
import pl.akademiakodu.database.model.onetoone.Contact;
import pl.akademiakodu.database.model.onetoone.User;
import pl.akademiakodu.database.repository.EmployeeRepository;
import pl.akademiakodu.database.repository.MeetingRepository;
import pl.akademiakodu.database.repository.UserRepository;
import pl.akademiakodu.database.service.ProductService;
import pl.akademiakodu.database.service.ShoppingCartService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}


	@Autowired
	MeetingRepository meetingRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Bean
	public CommandLineRunner runWithDb(ShoppingCartService shoppingCartService, UserRepository userRepository){
		return (args -> {

			ShoppingCart shoppingCartFirst = buildShoppingCartWithProducts("first", "milk", "bread", "butter");
			ShoppingCart shoppingCartSecond = buildShoppingCartWithProducts("second", "bmw", "audi", "masertti");

			shoppingCartService.save(shoppingCartFirst);
			shoppingCartService.save(shoppingCartSecond);


			User john = new User("John");
			Address address = new Address("Grodzka", "AirPolluted", john);
			john.setAddress(address);
			john.setContact(new Contact("asdfas@gfds.com", "34534534543"));

			userRepository.save(john);


			Meeting meeting1 = new Meeting("meeting1");
			Meeting meeting2 = new Meeting("meeting2");

			Employee employee = new Employee("Imie", "Nazwisko");
			Employee employee2 = new Employee("Imie2", "Nazwisko2");

			employee.addMeeting(meeting1);
			employee.addMeeting(meeting2);
			employee2.addMeeting(meeting2);

			meetingRepository.save(meeting1);
			meetingRepository.save(meeting2);

			employeeRepository.save(employee);
			employeeRepository.save(employee2);

		});
	}

	private ShoppingCart buildShoppingCartWithProducts(String shoppingCartName, String product1Name, String product2Name, String product3Name) {
		ShoppingCart shoppingCart = new ShoppingCart(shoppingCartName);

		Product product1 = new Product(product1Name, shoppingCart);
		Product product2 = new Product(product2Name, shoppingCart);
		Product product3 =  new Product(product3Name, shoppingCart);

		List<Product> products =new ArrayList<>();
		products.add(product1);
		products.add(product2);
		products.add(product3);

		shoppingCart.setProducts(products);
		return shoppingCart;
	}

}
