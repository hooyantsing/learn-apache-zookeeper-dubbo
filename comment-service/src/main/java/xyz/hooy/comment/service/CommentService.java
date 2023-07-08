package xyz.hooy.comment.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import xyz.hooy.comment.api.entity.Comment;
import xyz.hooy.comment.dao.CommentDao;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

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

    public List<Comment> getCommentsByDetailId(Long detailId) {
        if (Objects.nonNull(detailId)) {
            long i = detailId;
            return allComments().stream()
                    .filter(comment -> i == comment.getDetailId())
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    /**
     * 超时
     */
    @SneakyThrows
    public List<String> getCommentsNameByDetailId(Long detailId) {
        Thread.sleep(2 * 1000);
        if (Objects.nonNull(detailId)) {
            return getCommentsByDetailId(detailId).stream()
                    .map(Comment::getName)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    /**
     * 重试
     */
    @SneakyThrows
    public List<String> getCommentsContentByDetailId(Long detailId) {
        int i = ThreadLocalRandom.current().nextInt(2);
        System.err.println(i);
        if (i > 0) {
            Thread.sleep(2 * 1000);
        }
        if (Objects.nonNull(detailId)) {
            return getCommentsByDetailId(detailId).stream()
                    .map(Comment::getContent)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
