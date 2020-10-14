package se.lexicon.jpa_workshop.dao;

import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;
import se.lexicon.jpa_workshop.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product create(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("product cannot be null");
        }
        entityManager.persist(product);
        return product;
    }

    @Override
    public Product findById(int productId) {
        return entityManager.find(Product.class, productId);
    }

    @Override
    public Collection<Product> findAll() {
        Query query = entityManager.createQuery("Select p from Product p");
        return query.getResultList();
    }

    @Override
    public Collection<Product> findByName(String productName) {
        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.name = ?1");
        query.setParameter(1, productName);
        return query.getResultList();
    }

    @Override
    public Product update(Product product) {
        return entityManager.merge(product);
    }

    @Override
    public boolean delete(Product product) {
        entityManager.remove(product);
        return true;
    }
}
