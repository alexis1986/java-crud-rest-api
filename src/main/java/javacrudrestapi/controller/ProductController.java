package javacrudrestapi.controller;

import javacrudrestapi.model.Product;
import javacrudrestapi.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/products")
    public void create(@RequestBody Product product) {
        service.create(product);
    }

    @DeleteMapping("/products/{productId}")
    public void delete(long productId) {
        service.delete(productId);
    }

    @PatchMapping("/products/{productId}")
    public void update(long productId, @RequestBody Product product) {
        service.update(productId, product);
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return service.findAll();
    }

    @GetMapping("/products/{productId}")
    public Product findById(long productId) {
        return service.findById(productId);
    }

    @GetMapping("/products/{productName}")
    public List<Product> findByName(String productName) {
        return service.findByName(productName);
    }
}
