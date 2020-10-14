package se.lexicon.jpa_workshop.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.jpa_workshop.entity.Product;

import java.util.List;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */

@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepo productRepo;

    Product testObject;

    @BeforeEach
    public void setUp() {
        testObject = new Product("Boots", 1999.0);
        Product saveObject = productRepo.save(testObject);
    }

    @Test
    public void test_find_by_name(){
        List<Product> findProductsByName = productRepo.findByName("Boots");
        System.out.println("findProductsByName = " + findProductsByName);
    }
}
