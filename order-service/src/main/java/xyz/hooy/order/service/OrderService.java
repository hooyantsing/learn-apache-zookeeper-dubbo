package xyz.hooy.order.service;

import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import xyz.hooy.detail.api.dubbo.DetailDubbo;
import xyz.hooy.detail.api.entity.FullDetail;
import xyz.hooy.order.api.entity.FullOrder;
import xyz.hooy.order.api.entity.Order;
import xyz.hooy.order.dao.OrderDao;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderDao orderDao;

    @DubboReference
    private DetailDubbo detailDubbo;

    public FullOrder getOrder() {
        Order order = orderDao.getOrder();
        FullDetail fullDetail = detailDubbo.getFullDetailByOrderId(order.getId());
        return new FullOrder(order, fullDetail);
    }
}
