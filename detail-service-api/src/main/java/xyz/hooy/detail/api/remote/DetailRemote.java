package xyz.hooy.detail.api.remote;

import xyz.hooy.detail.api.entity.Detail;

public interface DetailRemote {

    Detail getDetailById(Long id);

    String getDetailNameById(Long id);

    String getDetailIntroductionById(Long id);

    Detail getDetailByOrderId(Long orderId);
}
