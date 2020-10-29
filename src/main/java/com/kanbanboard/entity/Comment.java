package com.kanbanboard.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author Wenyan Liu
 * @since 2020-10-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("Comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CommentID", type = IdType.AUTO)
    private Integer CommentID;

    @TableField("Contact")
    @NotBlank
    @JsonProperty("contact")
    private String Contact;

    @TableField("Comment")
    @NotBlank
    @JsonProperty("content")
    private String Comment;

    @TableField("Author")
    @NotBlank
    @JsonProperty("author")
    private String Author;
}
