package br.com.supera.tennis;

import br.com.supera.tennis.store.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class TennisStoreApplication {

	public static void main(String[] args) {

		SpringApplication.run(TennisStoreApplication.class, args);

	}

}
