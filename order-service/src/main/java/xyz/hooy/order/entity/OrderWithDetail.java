package xyz.hooy.order.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.hooy.detail.api.entity.Detail;
import xyz.hooy.order.api.entity.Order;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderWithDetail extends Order implements Serializable {

    private Detail detail;

    public OrderWithDetail(Long id, String title) {
        super(id, title);
    }

    public OrderWithDetail(Order order, Detail detail) {
        this(order.getId(), order.getTitle());
        this.detail = detail;
    }
}
