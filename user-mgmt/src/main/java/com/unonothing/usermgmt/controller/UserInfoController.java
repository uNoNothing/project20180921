package com.unonothing.usermgmt.controller;

import com.unonothing.common.dto.BaseDTO;
import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;
import com.unonothing.usermgmt.dto.UserInfoDTO;
import com.unonothing.usermgmt.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(value = "user controller")
@RestController
public class UserInfoController {

    private static final Logger log = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private IUserInfoService userInfoService;

    @ApiOperation(value = "create user", notes = "create user with address or email or phone")
    @PostMapping("/user")
    public void create(@RequestBody @Valid UserInfoDTO userInfoDTO, BindingResult bindingResult) {
        if (log.isTraceEnabled()) {
            log.trace("POST /user");
        }
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
    @GetMapping("/user")
    public List<UserInfoDTO> get() {
        if (log.isTraceEnabled()) {
            log.trace("GET /user");
        }
        return userInfoService.read();
    }

    // use only when you can not delete user
    @ApiOperation(value = "disable a user")
    @PutMapping("/user")
    public void disable(@RequestBody BaseDTO baseDTO) {
        if (log.isTraceEnabled()) {
            log.trace("PUT /user");
        }
        userInfoService.disable(baseDTO);
    }

    @ApiOperation(value = "get one user")
    @GetMapping("/user/{userId}")
    public UserInfoDTO get(@PathVariable Integer userId) {
        if (log.isTraceEnabled()) {
            log.trace("GET /user/" + userId);
        }

        BaseDTO baseDTO = new BaseDTO();
        if (userId != null) {
            baseDTO.setId(userId);
        } else {
            throw ExceptionFactory.create(ExceptionType.BAD_REQUEST, "userId", userId);
        }
        return userInfoService.read(baseDTO);
    }

    @ApiOperation(value = "delete a user")
    @DeleteMapping("/user")
    public void delete(@RequestBody BaseDTO baseDTO) {
        if (log.isTraceEnabled()) {
            log.trace("DELETE /user");
        }
        userInfoService.delete(baseDTO);
    }
}