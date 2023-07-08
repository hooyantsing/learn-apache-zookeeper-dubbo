package xyz.hooy.detail.service;

import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import xyz.hooy.comment.api.dubbo.CommentDubbo;
import xyz.hooy.comment.api.entity.Comment;
import xyz.hooy.detail.api.entity.Detail;
import xyz.hooy.detail.api.entity.FullDetail;
import xyz.hooy.detail.dao.DetailDao;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailService {

    private final DetailDao detailDao;

    @DubboReference
    private CommentDubbo commentDubbo;

    public Detail getDetailById(Long id) {
        return detailDao.getDetail();
    }

    public String getDetailNameById(Long id) {
        return getDetailById(id).getName();
    }

    public String getDetailIntroductionById(Long id) {
        return getDetailById(id).getIntroduction();
    }

    public FullDetail getFullDetailById(Long id) {
        Detail detail = getDetailById(id);
        List<Comment> comments = commentDubbo.allComments();
        return new FullDetail(detail, comments);
    }

    public FullDetail getFullDetailWithFirstCommentNameById(Long id) {
        Detail detail = getDetailById(id);
        String firstCommentName = commentDubbo.getFirstCommentNameByDetailId(id);
        return new FullDetail(detail, Collections.singletonList(firstCommentName));
    }

    public FullDetail getFullDetailWithFirstCommentContentById(Long id) {
        Detail detail = getDetailById(id);
        String firstCommentContent = commentDubbo.getFirstCommentContentByDetailId(id);
        return new FullDetail(detail, Collections.singletonList(firstCommentContent));
    }
}
