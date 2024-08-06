package org.spring.springboot.controller;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.common.anno.JwtIgnore;
import org.spring.springboot.common.enums.BusiCodeEnum;
import org.spring.springboot.common.enums.SysCodeEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.user.UserInfo;
import org.spring.springboot.domain.user.UserRegisterVO;
import org.spring.springboot.domain.user.UserVO;
import org.spring.springboot.service.UserService;
import org.spring.springboot.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.util.Elements;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public Result<?> login(UserVO userVO, HttpServletResponse response){
        //...参数合法性验证
        if(userVO == null) {
            return Result.buildFailure(BusiCodeEnum.PARAM_ERROR);
        }
        if(StringUtils.isEmpty(userVO.getUserName())) {
            return Result.buildFailure(BusiCodeEnum.PARAM_ERROR, "用户名不能为空");
        }
        if(StringUtils.isEmpty(userVO.getPassword())) {
            return Result.buildFailure(BusiCodeEnum.PARAM_ERROR, "密码不能为空");
        }
        try {
            //登录
            String token = userService.login(userVO, response);
            if (!StringUtils.isEmpty(token)) {
                return Result.buildSuccess().add("data", token);
            }
        } catch (Exception e) {
            log.error("UserCtrl#login error userVO is{} ,e", JSONUtil.toJsonStr(userVO), e);
        }

        return Result.buildFailure(BusiCodeEnum.LOGIN_ERROR);

    }

    @JwtIgnore
    @RequestMapping(value = "/register")
    public Result<?> register(@RequestBody UserRegisterVO registerVO, HttpServletResponse response){
        //...参数合法性验证
        if(registerVO == null) {
            return Result.buildFailure(BusiCodeEnum.PARAM_ERROR);
        }
        if(StringUtils.isEmpty(registerVO.getUserName())) {
            return Result.buildFailure(BusiCodeEnum.PARAM_ERROR, "用户名不能为空");
        }
        if(StringUtils.isEmpty(registerVO.getPassword())) {
            return Result.buildFailure(BusiCodeEnum.PARAM_ERROR, "密码不能为空");
        }
        if(StringUtils.isEmpty(registerVO.getRole())) {
            return Result.buildFailure(BusiCodeEnum.PARAM_ERROR, "角色不能为空");
        }
        if(StringUtils.isEmpty(registerVO.getPhone())) {
            return Result.buildFailure(BusiCodeEnum.PARAM_ERROR, "手机号不能为空");
        }
        try {
            //注册
            boolean login = userService.register(registerVO, response);
            if (login) {
                return Result.buildSuccess();
            }
        } catch (Exception e) {
            log.error("UserCtrl#register error userVO is{} ,e", JSONUtil.toJsonStr(registerVO), e);
        }

        return Result.buildFailure(BusiCodeEnum.REGISTER_ERROR);

    }


    /**
     *
     * 根据用户名查询用户信息
     * @param username
     * @author 13540
     * @date 2023-07-30 14:27
     * @return
     */
    @RequestMapping(value = "/getUserInfoByName")
    public Result<?> getUserInfoByName(@RequestParam("username") String username) {
        if(StringUtils.isEmpty(username)) {
            return Result.buildFailure(BusiCodeEnum.PARAM_ERROR);
        }
        try {
            UserInfo userInfo = userService.getUserInfoByName(username);
            if(userInfo != null) {
                return Result.buildSuccess().add("data", userInfo);
            }
        }catch (Exception e) {
            log.error("UserCtrl#getUserInfoByName error username is{} ,e", username, e);
        }

        return Result.buildFailure(BusiCodeEnum.BUSINESS_ERROR);

    }
    @JwtIgnore
    @RequestMapping(value = "/getAreaByIp")
    public String getAreaByIp(HttpServletRequest request) {
        String ipAddress;
        ipAddress = request.getHeader("x-forwarded-for");
        if (null == ipAddress || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (null == ipAddress || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (null == ipAddress || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_CLIENT_IP");
        }
        if (null == ipAddress || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (null == ipAddress || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("X-Real-IP");
        }
        if (null == ipAddress || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if ("127.0.0.1".equals(ipAddress) || "0:0:0:0:0:0:0:1".equals(ipAddress)) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(',') > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(','));
            }
        }
        String host = "https://api01.aliyun.venuscn.com";
        String path = "/ip";
        String method = "GET";
        String appcode = "be807576f74b466399816449d5fc807d";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("ip", ipAddress);
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //获取response的body
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "请求失败";
    }

}
