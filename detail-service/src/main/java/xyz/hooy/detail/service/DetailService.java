package xyz.hooy.detail.service;

import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import xyz.hooy.comment.api.dubbo.CommentDubbo;
import xyz.hooy.detail.api.entity.Detail;
import xyz.hooy.detail.entity.FullDetail;
import xyz.hooy.detail.dao.DetailDao;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailService {

    private final DetailDao detailDao;

    @DubboReference(check = false)
    private CommentDubbo commentDubbo;

    public Detail getDetailById(Long id) {
        long i = id;
        return detailDao.allDetails().stream()
                .filter(detail -> i == detail.getId())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such detailId: " + i));
    }

    public String getDetailNameById(Long id) {
        return getDetailById(id).getName();
    }

    public String getDetailIntroductionById(Long id) {
        return getDetailById(id).getIntroduction();
    }

    public FullDetail<String> getFullDetailWithCommentsNameById(Long id) {
        Detail detail = getDetailById(id);
        List<String> commentsName = commentDubbo.getCommentsNameByDetailId(id);
        return new FullDetail<>(detail, commentsName);
    }

    public FullDetail<String> getFullDetailWithCommentsContentById(Long id) {
        Detail detail = getDetailById(id);
        List<String> commentsContent = commentDubbo.getCommentsContentByDetailId(id);
        return new FullDetail<>(detail, commentsContent);
    }

    public Detail getDetailByOrderId(Long orderId) {
        long i = orderId;
        return detailDao.allDetails().stream()
                .filter(detail -> i == detail.getOrderId())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such orderId: " + i));
    }
}
