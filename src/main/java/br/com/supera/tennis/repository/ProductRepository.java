package br.com.supera.tennis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.supera.tennis.store.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
