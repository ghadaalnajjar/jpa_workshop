package se.lexicon.jpa_workshop.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.jpa_workshop.entity.Product;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
@SpringBootTest
@AutoConfigureTestEntityManager
@AutoConfigureTestDatabase
@Transactional
public class ProductDaoImplTest {

    @Autowired
    ProductDao productDao;

    @Autowired
    TestEntityManager testEntityManager;

    Product testObject;

    @BeforeEach
    void setUp() {
        Product pen = new Product("Pen", 10.0);
        testObject = testEntityManager.persist(pen);
    }

    @Test
    void test_create() {
        Product newProduct = new Product("boot", 100.0);
        productDao.create(newProduct);
        Product find = testEntityManager.find(Product.class, newProduct.getProductId());
        assertEquals(newProduct,find);
    }

    @Test
    void findAll() {

        //Arrange
        Collection<Product> expected = Arrays.asList(testObject);

        //Act
        Collection<Product> actual = productDao.findAll();

        //Assert
        assertEquals(expected, actual);

    }


    @Test
    void findByName() {
        //Arrange
        Collection<Product> expected = Arrays.asList(testObject);

        //Act
        Collection<Product> actual = productDao.findByName(testObject.getName());

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void update() {
        //Arrange
        Product expected = new Product(testObject.getProductId(), "Pen", 19.90);

        //Act
        Product actual = productDao.update(expected);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void delete() {

        //Arrange
        boolean deleted = false;

        //Act
        deleted = productDao.delete(testObject);

        //Assert
        assertNull(testEntityManager.find(Product.class, testObject.getProductId()));
        assertTrue(deleted);
    }

}
