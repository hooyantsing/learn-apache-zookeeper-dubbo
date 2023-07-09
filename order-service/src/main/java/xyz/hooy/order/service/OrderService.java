package xyz.hooy.order.service;

import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import xyz.hooy.detail.api.dubbo.DetailDubbo;
import xyz.hooy.detail.api.entity.Detail;
import xyz.hooy.order.entity.OrderWithDetail;
import xyz.hooy.order.api.entity.Order;
import xyz.hooy.order.dao.OrderDao;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderDao orderDao;

    @DubboReference(check = false)
    private DetailDubbo detailDubbo;

    public OrderWithDetail getOrder() {
        Order order = orderDao.getOrder();
        Detail detail = detailDubbo.getDetailByOrderId(order.getId());
        return new OrderWithDetail(order, detail);
    }
}
