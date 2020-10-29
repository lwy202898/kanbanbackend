package com.kanbanboard.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.sql.Blob;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@TableName("Applicant")
public class Applicant implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Contact")
    @JsonProperty("contact")
    private String Contact;

    @TableField("FirstName")
    @NotBlank
    @JsonProperty("firstname")
    private String FirstName;

    @TableField("LastName")
    @NotBlank
    @JsonProperty("lastname")
    private String LastName;

    @TableField("Education")
    @NotBlank
    @JsonProperty("education")
    private String Education;

    @TableField("Status")
    @NotBlank
    @JsonProperty("status")
    private String Status;

    @TableField("Resume")
    private Blob Resume;

    @TableField("Rate")
    @NotBlank
    @JsonProperty("rate")
    private Double Rate;

    @TableField("RateCount")
    @JsonProperty("ratecount")
    private Integer RateCount;


}
