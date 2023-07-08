package xyz.hooy.order.api.entity;

import java.io.Serializable;

public class FullOrder extends Order implements Serializable {

    private Object commodity;

    public FullOrder(Long id, String title) {
        super(id, title);
    }

    public FullOrder(Order order, Object commodity) {
        this(order.getId(), order.getTitle());
        this.commodity = commodity;
    }

    public Object getCommodity() {
        return commodity;
    }

    public void setCommodity(Object commodity) {
        this.commodity = commodity;
    }
}
