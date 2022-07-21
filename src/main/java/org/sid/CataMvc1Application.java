package org.sid;

import org.sid.dao.ProductRepository;
import org.sid.entities.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CataMvc1Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CataMvc1Application.class, args);
		ProductRepository productRepository = ctx.getBean(ProductRepository.class);
		productRepository.save(new Product("LX 4352", 670, 90));
		productRepository.save(new Product("Ord HP 432", 670, 90));
		productRepository.save(new Product("Imprimante Epson", 450, 12));
		productRepository.save(new Product("Imprimante HP 5400", 45, 10));
		
		productRepository.findAll().forEach(p-> System.out.println(p.getDesignation()));	
		}
}
