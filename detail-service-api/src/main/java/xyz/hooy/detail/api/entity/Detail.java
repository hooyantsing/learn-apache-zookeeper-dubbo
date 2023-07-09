package xyz.hooy.detail.api.entity;

import java.io.Serializable;

public class Detail implements Serializable {

    private Long id;
    private Long orderId;
    private String name;
    private String introduction;

    public Detail() {
    }

    public Detail(Long id, Long orderId, String name, String introduction) {
        this.id = id;
        this.orderId = orderId;
        this.name = name;
        this.introduction = introduction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
