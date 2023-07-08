package xyz.hooy.order.dao;

import org.springframework.stereotype.Repository;
import xyz.hooy.order.api.entity.Order;

@Repository
public class OrderDao {

    private final Order ORDER = new Order(1L, "JD");

    public Order getOrder() {
        return ORDER;
    }
}
