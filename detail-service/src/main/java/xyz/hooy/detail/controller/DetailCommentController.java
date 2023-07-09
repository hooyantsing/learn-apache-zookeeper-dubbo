package xyz.hooy.detail.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hooy.detail.entity.DetailWithComments;
import xyz.hooy.detail.service.DetailService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/detail-comment")
public class DetailCommentController {

    private final DetailService detailService;

    @GetMapping("/name/{detailId}")
    public DetailWithComments testTimeout(@PathVariable("detailId") Long detailId) {
        return detailService.getDetailWithCommentNamesById(detailId);
    }

    @GetMapping("/content/{detailId}")
    public DetailWithComments testRetry(@PathVariable("detailId") Long detailId) {
        return detailService.getDetailWithCommentContentsById(detailId);
    }
}
