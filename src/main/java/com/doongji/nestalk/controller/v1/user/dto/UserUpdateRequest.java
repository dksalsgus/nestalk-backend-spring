package com.doongji.nestalk.controller.v1.user.dto;

import com.doongji.nestalk.entity.user.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDate;

import static org.springframework.beans.BeanUtils.copyProperties;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserUpdateRequest {

    @ApiModelProperty(value = "PK", required = true)
    private Long userId;

    @ApiModelProperty(value = "사용자명", required = true)
    private String name;

    @ApiModelProperty(value = "전화번호", required = true)
    private String phone;

    @ApiModelProperty(value = "생년월일", required = true)
    private LocalDate birthday;

    public UserUpdateRequest(User source) {
        copyProperties(source, this);
    }

}
