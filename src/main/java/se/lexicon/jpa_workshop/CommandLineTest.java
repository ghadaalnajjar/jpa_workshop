package se.lexicon.jpa_workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.jpa_workshop.entity.Product;
import se.lexicon.jpa_workshop.repository.ProductRepo;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */

@Component
public class CommandLineTest implements CommandLineRunner {

    @Autowired
    ProductRepo productRepo;

    @Override
    public void run(String... args) throws Exception {
        productRepo.save(new Product("Test",100.0));
        System.out.println("######################################");
    }
}
