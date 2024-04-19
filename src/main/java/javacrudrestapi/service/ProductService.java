package javacrudrestapi.service;

import javacrudrestapi.model.Product;
import javacrudrestapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void create(Product product) {
        repository.save(product);
    }

    public void delete(long productId) {
        Product product = repository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        repository.delete(product);
    }

    public void update(long productId, Product product) {
        Product existingProduct = repository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setColor(product.getColor());
        existingProduct.setPrice(product.getPrice());
        repository.save(existingProduct);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(long productId) {
        return repository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> findByName(String productName) {
        return repository.findByProductName(productName);
    }
}
