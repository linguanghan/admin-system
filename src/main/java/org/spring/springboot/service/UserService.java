package org.spring.springboot.service;

import org.spring.springboot.domain.user.UserInfo;
import org.spring.springboot.domain.user.UserRegisterVO;
import org.spring.springboot.domain.user.UserVO;

import javax.servlet.http.HttpServletResponse;

public interface UserService {
    /**
     * 登录
     */
    String login(UserVO userVO, HttpServletResponse response) throws Exception;

    /**
     * 注冊
     */
    boolean register(UserRegisterVO userVO, HttpServletResponse response);


    /**
     * 获取信息
     */
    UserInfo getUserInfoByName(String username);
}
