package se.lexicon.jpa_workshop.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
@Entity
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productOrderId;
    private LocalDateTime orderDateTime;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "productOrder",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            orphanRemoval = true
    )
    private List<OrderItem> orderItems;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "appUser_id")
    private AppUser customer;

    public ProductOrder() {
    }

    public ProductOrder(LocalDateTime orderDateTime, List<OrderItem> orderItems, AppUser customer) {
        this.orderDateTime = orderDateTime;
        this.orderItems = orderItems;
        this.customer = customer;
    }

    public ProductOrder(int productOrderId, LocalDateTime orderDateTime, List<OrderItem> orderItems, AppUser customer) {
        this.productOrderId = productOrderId;
        this.orderDateTime = orderDateTime;
        this.orderItems = orderItems;
        this.customer = customer;
    }

    public ProductOrder(LocalDateTime orderDateTime, AppUser customer) {
        this.orderDateTime = orderDateTime;
        this.customer = customer;
    }

    public int getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(int productOrderId) {
        this.productOrderId = productOrderId;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public AppUser getCustomer() {
        return customer;
    }

    public void setCustomer(AppUser customer) {
        this.customer = customer;
    }

    /**
     * Convenience method <br/>
     * Adds in a bidirectional way <br/>
     * Adds order item to ProductOrder and ProductOrder to orderItem
     *
     * @param orderItem
     */
    public void addOrderItem(OrderItem orderItem) {
        if (orderItems == null) {
            orderItems = new ArrayList<>();
        }
        orderItems.add(orderItem);
    }

    /**
     * Convenience method <br/>
     * Adds in a bidirectional way <br/>
     * Adds order item to ProductOrder and ProductOrder to orderItem
     *
     * @param orderItem
     */
    public void removeOrderItem(OrderItem orderItem) {
        if (orderItems == null) {
            orderItems = new ArrayList<>();
        }
        if (orderItem == null) {
            throw new IllegalArgumentException("orderItem was " + null);
        }

        orderItems.remove(orderItem);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOrder that = (ProductOrder) o;
        return productOrderId == that.productOrderId &&
                Objects.equals(orderDateTime, that.orderDateTime) &&
                Objects.equals(orderItems, that.orderItems) &&
                Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productOrderId, orderDateTime, orderItems, customer);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductOrder{");
        sb.append("productOrderId=").append(productOrderId);
        sb.append(", orderDateTime=").append(orderDateTime);
        sb.append('}');
        return sb.toString();
    }
}
