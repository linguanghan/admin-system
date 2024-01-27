package org.spring.springboot.service;

import org.spring.springboot.domain.user.UserInfo;
import org.spring.springboot.domain.user.UserPO;
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

    /**
     *
     * 根据用户id获取用户信息
     * @author 13540
     * @date 2023-08-05 11:15 
     * @return org.spring.springboot.domain.user.UserPO
     */
    UserPO getUserInfoById(Integer id);
}
