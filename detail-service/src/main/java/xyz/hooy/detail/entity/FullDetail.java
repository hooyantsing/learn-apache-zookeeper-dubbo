package xyz.hooy.detail.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import xyz.hooy.detail.api.entity.Detail;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class FullDetail<T> extends Detail implements Serializable {

    private List<T> comments;

    public FullDetail(Long id, Long orderId, String name, String introduction, List<T> comments) {
        super(id, orderId, name, introduction);
        this.comments = comments;
    }

    public FullDetail(Detail detail, List<T> comments) {
        this(detail.getId(), detail.getOrderId(), detail.getName(), detail.getIntroduction(), comments);
    }
}
