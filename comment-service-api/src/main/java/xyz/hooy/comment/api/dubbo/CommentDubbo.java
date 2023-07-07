package xyz.hooy.comment.api.dubbo;

import xyz.hooy.comment.api.entity.Comment;

import java.util.List;

public interface CommentDubbo {

    List<Comment> allComments();

    Comment getCommentById(Long id);

    String getCommentNameById(Long id);

    String getCommentContentById(Long id);

    Integer getIndexForComments(Comment comment);
}
