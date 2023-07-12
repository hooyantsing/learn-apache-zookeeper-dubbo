package xyz.hooy.comment.api.remote;

import xyz.hooy.comment.api.entity.Comment;

import java.util.List;

public interface CommentRemote {

    Comment getCommentById(Long id);

    List<Comment> getCommentsByDetailId(Long detailId);

    List<String> getCommentNamesByDetailId(Long detailId);

    List<String> getCommentContentsByDetailId(Long detailId);
}
