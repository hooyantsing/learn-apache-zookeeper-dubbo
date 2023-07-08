package xyz.hooy.detail.dubbo;

import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import xyz.hooy.detail.api.dubbo.DetailDubbo;
import xyz.hooy.detail.api.entity.Detail;
import xyz.hooy.detail.api.entity.FullDetail;
import xyz.hooy.detail.service.DetailService;

@DubboService
@RequiredArgsConstructor
public class DetailDubboImpl implements DetailDubbo {

    private final DetailService detailService;

    @Override
    public Detail getDetailById(Long id) {
        return detailService.getDetailById(id);
    }

    @Override
    public String getDetailNameById(Long id) {
        return detailService.getDetailNameById(id);
    }

    @Override
    public String getDetailIntroductionById(Long id) {
        return detailService.getDetailIntroductionById(id);
    }

    @Override
    public FullDetail getFullDetailById(Long id) {
        return detailService.getFullDetailById(id);
    }

    @Override
    public FullDetail getFullDetailByOrderId(Long orderId) {
        return detailService.getFullDetailByOrderId(orderId);
    }
}
