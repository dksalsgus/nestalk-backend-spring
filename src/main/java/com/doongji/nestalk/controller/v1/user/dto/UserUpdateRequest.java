package com.doongji.nestalk.controller.v1.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserUpdateRequest {

    @ApiModelProperty(value = "사용자명", required = true)
    private String name;

    @ApiModelProperty(value = "전화번호", required = true)
    private String phone;

    @ApiModelProperty(value = "생년월일", required = true)
    private LocalDate birthday;

}
