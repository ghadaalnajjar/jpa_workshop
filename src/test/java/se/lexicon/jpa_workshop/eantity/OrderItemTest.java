package se.lexicon.jpa_workshop.eantity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.jpa_workshop.entity.OrderItem;
import se.lexicon.jpa_workshop.entity.Product;
import se.lexicon.jpa_workshop.entity.ProductOrder;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
public class OrderItemTest {

    OrderItem testObject;

    Integer id;
    Integer quantity;
    Product product;
    ProductOrder productOrder;

    @BeforeEach
    public void setUp() {
        id = 10;
        quantity = 100;
        product = new Product(10, "Pen", 10.0);
        productOrder = new ProductOrder();
        testObject = new OrderItem(id, quantity, product, productOrder);
    }

    @Test
    void test_successfully_created() {
        assertEquals(id, testObject.getOrderId());
        assertEquals(quantity, testObject.getQuantity());
        assertEquals(product, testObject.getProduct());
        assertEquals(productOrder, testObject.getProductOrder());
    }

    @Test
    public void test_equal() {
        OrderItem shouldBeEqual = new OrderItem(id, quantity, product, productOrder);
        assertEquals(testObject, shouldBeEqual);
    }

    @Test
    public void test_hashCode() {
        OrderItem shouldBeEqual = new OrderItem(id, quantity, product, productOrder);
        assertEquals(shouldBeEqual.hashCode(), testObject.hashCode());
    }

    @Test
    public void test_toString() {
        // implement test
    }

    @Test
    void test_calculate_OrderItems() {
        double expected = 1000.0;

        double actual = testObject.calculateOrderItems();

        assertEquals(expected,actual);
    }

    @Test
    void test_calculate_OrderItems_with_zero() {
        double expected = 0.0;
        testObject.setQuantity(0);
        double actual = testObject.calculateOrderItems();

        assertEquals(expected,actual);
    }

}
