package se.lexicon.jpa_workshop.dao;

import se.lexicon.jpa_workshop.entity.Product;

import java.util.Collection;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
public interface ProductDao {

    Product create(Product product);

    Product findById(int productId);

    Collection<Product> findAll();

    Collection<Product> findByName(String productName);

    Product update(Product product);

    boolean delete(Product product);

}
