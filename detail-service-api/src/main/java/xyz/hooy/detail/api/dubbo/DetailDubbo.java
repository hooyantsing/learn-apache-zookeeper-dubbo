package xyz.hooy.detail.api.dubbo;

import xyz.hooy.detail.api.entity.Detail;
import xyz.hooy.detail.api.entity.FullDetail;

public interface DetailDubbo {

    Detail getDetailById(String id);

    FullDetail getFullDetailById(String id);

    String getDetailNameById(String id);

    String getDetailIntroductionById(String id);
}
