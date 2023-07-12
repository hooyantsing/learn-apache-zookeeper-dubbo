package xyz.hooy.comment.remote;

import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import xyz.hooy.comment.api.remote.CommentRemote;
import xyz.hooy.comment.api.entity.Comment;
import xyz.hooy.comment.service.CommentService;

import java.util.List;

@DubboService
@RequiredArgsConstructor
public class CommentRemoteImpl implements CommentRemote {

    private final CommentService commentService;

    @Override
    public Comment getCommentById(Long id) {
        return commentService.getCommentById(id);
    }

    @Override
    public List<Comment> getCommentsByDetailId(Long detailId) {
        return commentService.getCommentsByDetailId(detailId);
    }

    @Override
    public List<String> getCommentNamesByDetailId(Long detailId) {
        return commentService.getCommentNamesByDetailId(detailId);
    }

    @Override
    public List<String> getCommentContentsByDetailId(Long detailId) {
        return commentService.getCommentContentsByDetailId(detailId);
    }
}
