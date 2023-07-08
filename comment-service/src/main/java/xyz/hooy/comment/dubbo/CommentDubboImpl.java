package xyz.hooy.comment.dubbo;

import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import xyz.hooy.comment.api.dubbo.CommentDubbo;
import xyz.hooy.comment.api.entity.Comment;
import xyz.hooy.comment.service.CommentService;

import java.util.List;

@DubboService
@RequiredArgsConstructor
public class CommentDubboImpl implements CommentDubbo {

    private final CommentService commentService;

    @Override
    public List<Comment> allComments() {
        return commentService.allComments();
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentService.getCommentById(id);
    }

    @Override
    public List<String> getCommentsNameByDetailId(Long detailId) {
        return commentService.getCommentsNameByDetailId(detailId);
    }

    @Override
    public List<String> getCommentsContentByDetailId(Long detailId) {
        return commentService.getCommentsContentByDetailId(detailId);
    }
}
