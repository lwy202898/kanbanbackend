package com.kanbanboard.service.impl;

import com.kanbanboard.entity.Comment;
import com.kanbanboard.mapper.CommentMapper;
import com.kanbanboard.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wenyan Liu
 * @since 2020-10-27
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
