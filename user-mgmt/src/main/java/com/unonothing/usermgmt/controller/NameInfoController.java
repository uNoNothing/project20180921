package com.unonothing.usermgmt.controller;

import com.unonothing.common.dto.BaseDTO;
import com.unonothing.common.exceptions.ExceptionFactory;
import com.unonothing.common.exceptions.ExceptionType;
import com.unonothing.usermgmt.dto.NameInfoDTO;
import com.unonothing.usermgmt.service.INameInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(value = "name controller")
@RestController
public class NameInfoController {

    private static final Logger log = LoggerFactory.getLogger(NameInfoController.class);

    @Autowired
    private INameInfoService nameInfoService;

    @ApiOperation(value = "update user name")
    @PutMapping("/name")
    public void update(@RequestBody @Valid NameInfoDTO nameInfoDTO, BindingResult bindingResult) {
        if (log.isTraceEnabled()) {
            log.trace("UPDATE /name");
        }
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldErrors().get(0);
            throw ExceptionFactory.create(ExceptionType.BAD_REQUEST,
                    fieldError.getField(), fieldError.getRejectedValue(),
                    fieldError.getDefaultMessage()
            );
        }
        nameInfoService.update(nameInfoDTO);
    }

    @ApiOperation(value = "get name history of user")
    @GetMapping("/name/{userId}")
    public List<NameInfoDTO> get(@PathVariable Integer userId){
        if (log.isTraceEnabled()){
            log.trace("GET /name/" + userId);
        }

        BaseDTO baseDTO = new BaseDTO();
        if (userId != null) {
            baseDTO.setId(userId);
        } else {
            throw ExceptionFactory.create(ExceptionType.BAD_REQUEST, "userId", null);
        }

        return nameInfoService.read(baseDTO);
    }
}