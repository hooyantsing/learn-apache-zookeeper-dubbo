package xyz.hooy.detail.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import xyz.hooy.comment.api.dubbo.CommentDubbo;

@Service
public class FlowControlService {

    @DubboReference
    private CommentDubbo commentDubbo;

    public String getCommentNameById(Long id) {
        return commentDubbo.getCommentNameById(id);
    }

    public String getCommentContentById(Long id) {
        return commentDubbo.getCommentContentById(id);
    }
}
