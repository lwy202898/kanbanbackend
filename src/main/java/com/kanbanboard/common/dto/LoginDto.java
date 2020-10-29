package com.kanbanboard.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class LoginDto implements Serializable {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}