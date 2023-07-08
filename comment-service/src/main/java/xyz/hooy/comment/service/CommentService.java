package xyz.hooy.comment.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import xyz.hooy.comment.api.entity.Comment;
import xyz.hooy.comment.dao.CommentDao;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentDao commentDao;

    public List<Comment> allComments() {
        return commentDao.allComments();
    }

    public Comment getCommentById(@Nullable Long id) {
        if (Objects.nonNull(id)) {
            long i = id;
            List<Comment> comments = allComments();
            for (Comment comment : comments) {
                if (i == comment.getId()) {
                    return comment;
                }
            }
        }
        return null;
    }

    public Comment getFirstCommentByDetailId(Long detailId) {
        if (Objects.nonNull(detailId)) {
            long i = detailId;
            List<Comment> comments = allComments();
            for (Comment comment : comments) {
                if (i == comment.getDetailId()) {
                    return comment;
                }
            }
        }
        return null;
    }

    /**
     * 超时
     */
    @SneakyThrows
    public String getFirstCommentNameByDetailId(Long detailId) {
        Thread.sleep(2 * 1000);
        if (Objects.nonNull(detailId)) {
            Comment firstComment = getFirstCommentByDetailId(detailId);
            if (Objects.nonNull(firstComment)) {
                return firstComment.getName();
            }
        }
        return null;
    }

    /**
     * 重试
     */
    @SneakyThrows
    public String getFirstCommentContentByDetailId(Long detailId) {
        int i = ThreadLocalRandom.current().nextInt(2);
        if (i > 0) {
            Thread.sleep(2 * 1000);
        }
        if (Objects.nonNull(detailId)) {
            Comment firstComment = getFirstCommentByDetailId(detailId);
            if (Objects.nonNull(firstComment)) {
                return firstComment.getContent();
            }
        }
        return null;
    }
}
