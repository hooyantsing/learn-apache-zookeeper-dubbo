package xyz.hooy.comment.dubbo;

import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.lang.Nullable;
import xyz.hooy.comment.api.dubbo.CommentInfoDubbo;
import xyz.hooy.comment.api.entity.Comment;
import xyz.hooy.comment.dao.CommentDao;

import java.util.List;
import java.util.Objects;

@DubboService
@RequiredArgsConstructor
public class CommentInfoDubboImpl implements CommentInfoDubbo {

    private final CommentDao commentDao;

    @Override
    public List<Comment> allComments() {
        return commentDao.allComments();
    }

    @Override
    public Comment getCommentById(@Nullable Long id) {
        if (Objects.nonNull(id)) {
            List<Comment> comments = allComments();
            for (Comment comment : comments) {
                long commentId = comment.getId();
                if (commentId == id) {
                    return comment;
                }
            }
        }
        return null;
    }

    @Override
    public String getCommentNameById(@Nullable Long id) {
        if (Objects.nonNull(id)) {
            Comment comment = getCommentById(id);
            return comment.getName();
        }
        return null;
    }

    @Override
    public Integer getIndexForComments(@Nullable Comment comment) {
        if (Objects.nonNull(comment) && Objects.nonNull(comment.getId())) {
            List<Comment> comments = allComments();
            for (int i = 0; i < comments.size(); i++) {
                Comment c = comments.get(i);
                long cId = c.getId();
                if (cId == comment.getId()) {
                    return i;
                }
            }
        }
        return null;
    }
}
