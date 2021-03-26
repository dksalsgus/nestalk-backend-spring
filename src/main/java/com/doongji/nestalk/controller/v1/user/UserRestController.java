package com.doongji.nestalk.controller.v1.user;

import com.doongji.nestalk.controller.v1.user.dto.*;
import com.doongji.nestalk.entity.user.Role;
import com.doongji.nestalk.entity.user.User;
import com.doongji.nestalk.security.Jwt;
import com.doongji.nestalk.security.JwtAuthentication;
import com.doongji.nestalk.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(tags = "사용자 APIs")
@RequestMapping("api/v1")
@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UserService userService;

    private final Jwt jwt;

    @ApiOperation(value = "사용자 등록 (JWT 불필요)")
    @PostMapping(path = "user/join")
    public ResponseEntity<JoinResult> join(@RequestBody JoinRequest joinRequest) {
        User user = userService.join(
                joinRequest.getEmail(),
                joinRequest.getName(),
                joinRequest.getPassword(),
                joinRequest.getPhone(),
                joinRequest.getBirthday()
        );

        String token = user.createToken(jwt, new String[]{Role.USER.value()});
        return ResponseEntity.ok(new JoinResult(token, new UserDto(user)));
    }

    @ApiOperation(value = "이메일 중복확인 (JWT 불필요)")
    @PostMapping(path = "user/exists")
    public ResponseEntity<Boolean> checkEmail(
            @RequestBody @ApiParam(value = "example: {\"email\": \"doongji.team@gmail.com\"}") Map<String, String> request
    ) {
        String email = request.get("email");
        return ResponseEntity.ok(
                userService.findByEmail(email).isPresent()
        );
    }

    @ApiOperation(value = "이메일 찾기 (JWT 불필요)")
    @PostMapping(path = "user/email")
    public ResponseEntity<FindEmailResponse> checkEmail(@RequestBody FindEmailRequest request) {
        String email = userService.findEmailByNameAndPhone(request.getName(), request.getPhone());
        return ResponseEntity.ok(new FindEmailResponse(email));
    }

    @ApiOperation(value = "회원 정보 수정")
    @PutMapping(path = "user")
    public ResponseEntity<UserDto> updateUser(@AuthenticationPrincipal JwtAuthentication jwtAuthentication, @RequestBody UserUpdateRequest updateRequest) {
        User updateUser = userService.userUpdate(jwtAuthentication.userId,updateRequest);
        return ResponseEntity.ok(new UserDto(updateUser));
    }
}
