package xyz.hooy.comment.api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Comment implements Serializable {

    private Long id;
    private Long detailId;
    private String name;
    private String content;
    private LocalDateTime timestamp;

    public Comment() {
    }

    public Comment(Long id, Long detailId, String name, String content, LocalDateTime timestamp) {
        this.id = id;
        this.detailId = detailId;
        this.name = name;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
