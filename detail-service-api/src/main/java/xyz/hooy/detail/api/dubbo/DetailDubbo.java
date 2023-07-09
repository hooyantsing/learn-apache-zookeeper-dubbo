package xyz.hooy.detail.api.dubbo;

import xyz.hooy.detail.api.entity.Detail;

public interface DetailDubbo {

    Detail getDetailById(Long id);

    String getDetailNameById(Long id);

    String getDetailIntroductionById(Long id);

    Detail getDetailByOrderId(Long orderId);
}
