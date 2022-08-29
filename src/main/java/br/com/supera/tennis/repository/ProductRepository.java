package br.com.supera.tennis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import br.com.supera.tennis.store.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p order by p.price desc")
    List<Product> productsbyPrice();

    @Query("select p from Product p order by p.score desc")
    List<Product> productsbyScore();

    @Query("select p from Product p order by p.name")
    List<Product> productsbyAsc();
	
}
