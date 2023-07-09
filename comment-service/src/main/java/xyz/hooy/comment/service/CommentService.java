package xyz.hooy.comment.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.hooy.comment.api.entity.Comment;
import xyz.hooy.comment.dao.CommentDao;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentDao commentDao;

    public Comment getCommentById(Long id) {
        long i = id;
        return commentDao.allComments().stream()
                .filter(comment -> i == comment.getId())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such commentId: " + id));
    }

    public List<Comment> getCommentsByDetailId(Long detailId) {
        long i = detailId;
        return commentDao.allComments().stream()
                .filter(comment -> i == comment.getDetailId())
                .collect(Collectors.toList());
    }

    /**
     * 超时
     */
    @SneakyThrows
    public List<String> getCommentNamesByDetailId(Long detailId) {
        Thread.sleep(2 * 1000);
        return getCommentsByDetailId(detailId).stream()
                .map(Comment::getName)
                .collect(Collectors.toList());
    }

    /**
     * 重试
     */
    @SneakyThrows
    public List<String> getCommentContentsByDetailId(Long detailId) {
        int i = ThreadLocalRandom.current().nextInt(2);
        System.err.println(i);
        if (i > 0) {
            Thread.sleep(2 * 1000);
        }
        return getCommentsByDetailId(detailId).stream()
                .map(Comment::getContent)
                .collect(Collectors.toList());
    }
}
