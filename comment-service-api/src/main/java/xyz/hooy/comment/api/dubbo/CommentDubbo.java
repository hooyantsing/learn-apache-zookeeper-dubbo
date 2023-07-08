package xyz.hooy.comment.api.dubbo;

import xyz.hooy.comment.api.entity.Comment;

import java.util.List;

public interface CommentDubbo {

    List<Comment> allComments();

    Comment getCommentById(Long id);

    List<Comment> getCommentsByDetailId(Long detailId);

    List<String> getCommentsNameByDetailId(Long detailId);

    List<String> getCommentsContentByDetailId(Long detailId);
}
