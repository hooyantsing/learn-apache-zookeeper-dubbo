package xyz.hooy.detail.dao;

import org.springframework.stereotype.Repository;
import xyz.hooy.detail.api.entity.Detail;

import java.util.Collections;
import java.util.List;

@Repository
public class DetailDao {

    private final List<Detail> DETAILS = Collections.singletonList(new Detail(1L, 1L, "iPhoneX", "Say hello to the future"));

    public List<Detail> allDetails() {
        return DETAILS;
    }
}
