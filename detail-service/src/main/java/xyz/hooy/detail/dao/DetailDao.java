package xyz.hooy.detail.dao;

import org.springframework.stereotype.Repository;
import xyz.hooy.detail.api.entity.Detail;

@Repository
public class DetailDao {

    private final Detail DETAIL = new Detail(1L,"iPhoneX","Say hello to the future");

    public Detail getDetail() {
        return DETAIL;
    }
}
