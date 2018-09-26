package com.unonothing.usermgmt.controller;

import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;
import com.unonothing.usermgmt.dto.UserInfoDTO;
import com.unonothing.usermgmt.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(value = "user controller")
@RestController
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    @ApiOperation(value = "create user", notes = "create user with address or email or phone")
    @PostMapping(value = "/user")
    public void create(@Valid UserInfoDTO userInfoDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            throw ExceptionFactory.create(ExceptionType.BAD_REQUEST,
                    fieldError.getField(), fieldError.getRejectedValue(),
                    fieldError.getDefaultMessage()
            );
        }
        userInfoService.create(userInfoDTO);
    }

    @ApiOperation(value = "get all users")
    @GetMapping(value = "/user")
    public List<UserInfoDTO> get() {
        return userInfoService.read();
    }
}
