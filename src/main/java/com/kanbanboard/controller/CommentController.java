package com.kanbanboard.controller;


import com.kanbanboard.common.lang.Result;
import com.kanbanboard.entity.Comment;
import com.kanbanboard.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  Frontend Controller
 * </p>
 *
 * @author Wenyan Liu
 * @since 2020-10-27
 */
@RestController
public class CommentController {
    @Autowired
    CommentService commentService;
    @PostMapping("/add-comment")
    public Result addComment(@RequestBody Comment comment) {
        commentService.save(comment);
        return Result.succ(null);
    }
}
