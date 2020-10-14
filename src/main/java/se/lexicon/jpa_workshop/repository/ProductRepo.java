package se.lexicon.jpa_workshop.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.jpa_workshop.entity.Product;

import java.util.List;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
public interface ProductRepo extends CrudRepository<Product, Integer> {

    List<Product> findByName(String name);

}
