package xyz.hooy.detail.api.dubbo;

import xyz.hooy.detail.api.entity.Detail;
import xyz.hooy.detail.api.entity.FullDetail;

public interface DetailDubbo {

    Detail getDetailById(Long id);

    String getDetailNameById(Long id);

    String getDetailIntroductionById(Long id);

    FullDetail getFullDetailById(Long id);

    FullDetail getFullDetailByOrderId(Long orderId);
}
