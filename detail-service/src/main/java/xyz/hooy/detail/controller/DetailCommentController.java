package xyz.hooy.detail.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hooy.detail.entity.FullDetail;
import xyz.hooy.detail.service.DetailService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/detail-comment")
public class DetailCommentController {

    private final DetailService detailService;

    @GetMapping("/name/{detailId}")
    public FullDetail testTimeout(@PathVariable("detailId") Long detailId) {
        return detailService.getFullDetailWithCommentsNameById(detailId);
    }

    @GetMapping("/content/{detailId}")
    public FullDetail testRetry(@PathVariable("detailId") Long detailId) {
        return detailService.getFullDetailWithCommentsContentById(detailId);
    }
}
