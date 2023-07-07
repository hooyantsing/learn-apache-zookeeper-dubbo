package xyz.hooy.comment.dubbo;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.lang.Nullable;
import xyz.hooy.comment.api.dubbo.CommentDubbo;
import xyz.hooy.comment.api.entity.Comment;
import xyz.hooy.comment.dao.CommentDao;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@DubboService
@RequiredArgsConstructor
public class CommentDubboImpl implements CommentDubbo {

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

    /**
     * 模拟超时
     */
    @Override
    @SneakyThrows
    public String getCommentNameById(@Nullable Long id) {
        Thread.sleep(5 * 1000);
        if (Objects.nonNull(id)) {
            Comment comment = getCommentById(id);
            return comment.getName();
        }
        return null;
    }

    /**
     * 模拟重试
     */
    @Override
    @SneakyThrows
    public String getCommentContentById(Long id) {
        int i = ThreadLocalRandom.current().nextInt(2);
        log.info(String.valueOf(i));
        if (i > 0) {
            Thread.sleep(5 * 1000);
        }
        if (Objects.nonNull(id)) {
            Comment comment = getCommentById(id);
            return comment.getContent();
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
