package org.spring.springboot.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.spring.springboot.dao.yldres.UserDao;
import org.spring.springboot.domain.user.*;
import org.spring.springboot.service.UserService;
import org.spring.springboot.util.JwtTokenUtil;
import org.spring.springboot.util.RSAUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-29 16:18
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public String login(UserVO userVO, HttpServletResponse response) throws Exception{
        //1、用户、密码验证
        UserPO userPO = userDao.fetchUseByUserName(userVO.getUserName());
        if(userPO == null) {
            return null;
        }
        if (userPO.getPassword() == null) {
            return null;
        }
        if (!RSAUtil.decrypt(userPO.getPassword()).equals(RSAUtil.decrypt(userVO.getPassword()))) {
            return null;
        }
        //2、创建token，并将token放在响应头
        UserToken userToken = new UserToken();
        BeanUtils.copyProperties(userPO,userToken);
        String token = JwtTokenUtil.createToken(JSONObject.toJSONString(userToken));
        response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, token);
        return token;
    }


    @Override
    public boolean register(UserRegisterVO registerVO, HttpServletResponse response) {
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(registerVO, userPO);
        Integer save = userDao.saveUser(userPO);
        return save != null && save > 0;
    }

    @Override
    public UserInfo getUserInfoByName(String username){
        UserPO userPO = userDao.fetchUseByUserName(username);
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userPO, userInfo);
        return userInfo;
    }

    @Override
    public UserPO getUserInfoById(Integer id) {
        return userDao.fetchUserById(id);
    }


}
