package br.com.supera.tennis.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.supera.tennis.repository.ProductRepository;
import br.com.supera.tennis.store.Product;


@RestController
public class ProductController {
	
	 	
	    
	@Autowired
	private ProductRepository productRepository;
	
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
	//@Autowired
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("productDS");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @GetMapping("/productlistatodos")
    @ResponseBody
    public ResponseEntity<List<Product>> listaUsuario(){
    	List<Product> products = productRepository.findAll();
    	return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    
    }
    
    @GetMapping("/productsbyprice")
    @ResponseBody
    public ResponseEntity<List<Product>> productsbyPrice(){
    	List<Product> products = entityManager.
				createQuery("select p from Product p order by p.price desc").getResultList();
    	  System.out.print(products);
    	
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);	
    }
    
	
    
    @GetMapping("/productsbyscore")
    @ResponseBody
    public ResponseEntity<List<Product>> productsbyScore(){
    	List<Product> products = entityManager.
				createQuery("select p from Product p order by p.score desc").
				getResultList();
    	
    	
    	return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    
    }
    
   @GetMapping("/productsbyasc")
   @ResponseBody
   public ResponseEntity<List<Product>> productsbyAsc(){
	   List<Product> products = entityManager.
				createQuery("select p from Product p order by p.name").
				getResultList();
   		
   return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
   }
    
   @PostMapping(value = "productsalvar")
   @ResponseBody
    public ResponseEntity<Product> salvar(@RequestBody Product product){
    	Product prop = productRepository.save(product);
    	return new ResponseEntity<Product>(prop, HttpStatus.CREATED);
    }
   
   @DeleteMapping(value = "productdelete")
   @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long iduser){
    	productRepository.deleteById(iduser);
    	return new ResponseEntity<String>("Usuario deletado com sucesso", HttpStatus.OK);
    }
   
   @GetMapping(value = "productbuscaruserId")
   @ResponseBody
    public ResponseEntity<Product> buscaruserId(@RequestParam(name = "iduser") Long iduser){
    	Product product = productRepository.findById(iduser).get();
    	return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
}