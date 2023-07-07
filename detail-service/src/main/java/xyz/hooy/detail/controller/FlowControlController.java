package xyz.hooy.detail.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hooy.detail.service.FlowControlService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flow-control")
public class FlowControlController {

    private final FlowControlService flowControlService;

    @GetMapping("/timeout/{commentId}")
    public String testTimeout(@PathVariable("commentId") Long commentId) {
        return flowControlService.getCommentNameById(commentId);
    }

    @GetMapping("/retry/{commentId}")
    public String testRetry(@PathVariable("commentId") Long commentId) {
        return flowControlService.getCommentContentById(commentId);
    }
}
