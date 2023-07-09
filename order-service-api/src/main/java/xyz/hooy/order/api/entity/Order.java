package xyz.hooy.order.api.entity;

import java.io.Serializable;

public class Order implements Serializable {

    private Long id;
    private String title;

    public Order() {
    }

    public Order(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
