package xyz.hooy.comment.api.dubbo;

import xyz.hooy.comment.api.entity.Comment;

import java.util.List;

public interface CommentDubbo {

    Comment getCommentById(Long id);

    List<Comment> getCommentsByDetailId(Long detailId);

    List<String> getCommentNamesByDetailId(Long detailId);

    List<String> getCommentContentsByDetailId(Long detailId);
}
