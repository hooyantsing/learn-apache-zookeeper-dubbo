package xyz.hooy.detail.dubbo;

import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import xyz.hooy.comment.api.dubbo.CommentDubbo;
import xyz.hooy.comment.api.entity.Comment;
import xyz.hooy.detail.api.dubbo.DetailDubbo;
import xyz.hooy.detail.api.entity.Detail;
import xyz.hooy.detail.api.entity.FullDetail;
import xyz.hooy.detail.dao.DetailDao;

import java.util.List;

@DubboService
@RequiredArgsConstructor
public class DetailDubboImpl implements DetailDubbo {

    private final DetailDao detailDao;

    @DubboReference
    private CommentDubbo commentDubbo;

    @Override
    public Detail getDetailById(String id) {
        return detailDao.getDetail();
    }

    @Override
    public FullDetail getFullDetailById(String id) {
        Detail detail = getDetailById(id);
        List<Comment> comments = commentDubbo.allComments();
        return new FullDetail(detail, comments);
    }

    @Override
    public String getDetailNameById(String id) {
        return getDetailById(id).getName();
    }

    @Override
    public String getDetailIntroductionById(String id) {
        return getDetailById(id).getIntroduction();
    }
}
