package xyz.hooy.detail.api.entity;

import java.util.List;

public class FullDetail extends Detail {

    private List comments;

    public FullDetail(Long id, String name, String introduction, List comments) {
        super(id, name, introduction);
        this.comments = comments;
    }

    public FullDetail(Detail detail, List comments) {
        this(detail.getId(), detail.getName(), detail.getIntroduction(), comments);
    }

    public List getComments() {
        return comments;
    }

    public void setComments(List comments) {
        this.comments = comments;
    }
}
