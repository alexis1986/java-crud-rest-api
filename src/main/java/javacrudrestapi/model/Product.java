package javacrudrestapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_inventory")
@Data
public class Product {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "color")
    private String color;
    @Column(name = "price")
    private int price;
}
