package xyz.hooy.detail.api.entity;

import java.io.Serializable;
import java.util.List;

public class FullDetail extends Detail implements Serializable {

    private List comments;

    public FullDetail(Long id, Long orderId, String name, String introduction, List comments) {
        super(id, orderId, name, introduction);
        this.comments = comments;
    }

    public FullDetail(Detail detail, List comments) {
        this(detail.getId(), detail.getOrderId(), detail.getName(), detail.getIntroduction(), comments);
    }

    public List getComments() {
        return comments;
    }

    public void setComments(List comments) {
        this.comments = comments;
    }
}
