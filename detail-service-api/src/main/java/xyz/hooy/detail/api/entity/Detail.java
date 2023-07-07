package xyz.hooy.detail.api.entity;

public class Detail {

    private Long id;
    private String name;
    private String introduction;

    public Detail(Long id, String name, String introduction) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
