package pl.akademiakodu.database.model.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "shoppingCart_id")
    private ShoppingCart shoppingCartField;

    protected Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, ShoppingCart shoppingCartField) {
        this.name = name;
        this.shoppingCartField = shoppingCartField;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShoppingCart getShoppingCartField() {
        return shoppingCartField;
    }

    public void setShoppingCartField(ShoppingCart shoppingCartField) {
        this.shoppingCartField = shoppingCartField;
    }
}
