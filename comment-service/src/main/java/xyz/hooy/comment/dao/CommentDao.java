package xyz.hooy.comment.dao;

import org.springframework.stereotype.Repository;
import xyz.hooy.comment.api.entity.Comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentDao {

    private final List<Comment> COMMENTS = initComments();

    private List<Comment> initComments() {
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment(1L, 1L, "LiMing", "How are you ?", LocalDateTime.now()));
        comments.add(new Comment(2L, 1L, "Jenny", "I am fine, and you ?", LocalDateTime.now()));
        comments.add(new Comment(3L, 2L, "Danny", "I am fine, thank you !", LocalDateTime.now()));
        return comments;
    }

    public List<Comment> allComments() {
        return COMMENTS;
    }
}
