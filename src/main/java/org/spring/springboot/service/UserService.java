package org.spring.springboot.service;

import org.spring.springboot.common.anno.JwtIgnore;
import org.spring.springboot.domain.user.UserRegisterVO;
import org.spring.springboot.domain.user.UserVO;

import javax.servlet.http.HttpServletResponse;

public interface UserService {
    /**
     * 登录
     */
    boolean login(UserVO userVO, HttpServletResponse response);

    /**
     * 注冊
     */
    boolean register(UserRegisterVO userVO, HttpServletResponse response);

}
