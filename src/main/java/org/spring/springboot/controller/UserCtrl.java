package org.spring.springboot.controller;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.spring.springboot.common.anno.JwtIgnore;
import org.spring.springboot.common.enums.BusiCodeEnum;
import org.spring.springboot.common.enums.SysCodeEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.user.UserRegisterVO;
import org.spring.springboot.domain.user.UserVO;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-29 16:12
 */
@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserCtrl {
    @Autowired
    private UserService userService;

    @JwtIgnore
    @RequestMapping(value = "/login")
    public Result<?> login(@RequestBody UserVO userVO, HttpServletResponse response){
        //...参数合法性验证
        if(userVO == null) {
            return Result.buildFailure(BusiCodeEnum.ParamError);
        }
        if(StringUtils.isEmpty(userVO.getUserName())) {
            return Result.buildFailure(BusiCodeEnum.ParamError, "用户名不能为空");
        }
        if(StringUtils.isEmpty(userVO.getPassword())) {
            return Result.buildFailure(BusiCodeEnum.ParamError, "密码不能为空");
        }
        try {
            //登录
            boolean login = userService.login(userVO, response);
            if (login) {
                return Result.buildSuccess();
            }
        } catch (Exception e) {
            log.error("UserCtrl#login error userVO is{} ,e", JSONUtil.toJsonStr(userVO), e);
        }

        return Result.buildFailure(BusiCodeEnum.LoginError);

    }

    @JwtIgnore
    @RequestMapping(value = "/register")
    public Result<?> register(@RequestBody UserRegisterVO registerVO, HttpServletResponse response){
        //...参数合法性验证
        if(registerVO == null) {
            return Result.buildFailure(BusiCodeEnum.ParamError);
        }
        if(StringUtils.isEmpty(registerVO.getUserName())) {
            return Result.buildFailure(BusiCodeEnum.ParamError, "用户名不能为空");
        }
        if(StringUtils.isEmpty(registerVO.getPassword())) {
            return Result.buildFailure(BusiCodeEnum.ParamError, "密码不能为空");
        }
        if(StringUtils.isEmpty(registerVO.getRole())) {
            return Result.buildFailure(BusiCodeEnum.ParamError, "角色不能为空");
        }
        if(StringUtils.isEmpty(registerVO.getPhone())) {
            return Result.buildFailure(BusiCodeEnum.ParamError, "手机号不能为空");
        }
        try {
            //注册
            boolean login = userService.register(registerVO, response);
            if (login) {
                return Result.buildSuccess();
            }
        } catch (Exception e) {
            log.error("UserCtrl#login error userVO is{} ,e", JSONUtil.toJsonStr(registerVO), e);
        }

        return Result.buildFailure(BusiCodeEnum.RegisterError);

    }


}
