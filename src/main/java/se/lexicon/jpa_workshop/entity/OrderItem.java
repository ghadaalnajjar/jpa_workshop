package se.lexicon.jpa_workshop.entity;

import java.util.Objects;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
public class OrderItem {
    private int orderId;
    private int quantity;
    private Product product;
    private ProductOrder productOrder;

    public OrderItem() {
    }

    public OrderItem(int quantity, Product product, ProductOrder productOrder) {
        this.quantity = quantity;
        this.product = product;
        this.productOrder = productOrder;
    }

    public OrderItem(int orderId, int quantity, Product product, ProductOrder productOrder) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.product = product;
        this.productOrder = productOrder;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    /**
     * Calculate Quantity multiplied Product Price.
     *
     * @return result of calculation
     */
    public double calculateOrderItems() {
        double result = 0;
        if (product.getPrice() != 0 || getQuantity() != 0) {
            result = product.getPrice() * getQuantity();
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return orderId == orderItem.orderId &&
                quantity == orderItem.quantity &&
                Objects.equals(product, orderItem.product) &&
                Objects.equals(productOrder, orderItem.productOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, quantity, product, productOrder);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderItem{");
        sb.append("orderId=").append(orderId);
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}
