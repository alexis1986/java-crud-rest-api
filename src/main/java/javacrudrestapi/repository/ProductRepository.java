package javacrudrestapi.repository;

import javacrudrestapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p FROM product_inventory p WHERE p.productName = ?1", nativeQuery = true)
    List<Product> findByProductName(String productName);

}
