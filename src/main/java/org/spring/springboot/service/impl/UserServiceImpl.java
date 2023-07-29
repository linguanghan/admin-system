package org.spring.springboot.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.spring.springboot.dao.yldres.UserDao;
import org.spring.springboot.domain.user.UserPO;
import org.spring.springboot.domain.user.UserRegisterVO;
import org.spring.springboot.domain.user.UserToken;
import org.spring.springboot.domain.user.UserVO;
import org.spring.springboot.service.UserService;
import org.spring.springboot.util.JwtTokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    public boolean login(UserVO userVO, HttpServletResponse response) {
        //1、用户、密码验证
        UserPO userPO = userDao.fetchUseByUserName(userVO.getUserName());
        if (userPO.getPassword() == null) {
            return false;
        }
        if (!userPO.getPassword().equals(userVO.getPassword())) {
            return false;
        }
        //2、创建token，并将token放在响应头
        UserToken userToken = new UserToken();
        BeanUtils.copyProperties(userPO,userToken);
        String token = JwtTokenUtil.createToken(JSONObject.toJSONString(userToken));
        response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, token);
        return true;
    }


    @Override
    public boolean register(UserRegisterVO registerVO, HttpServletResponse response) {
        UserPO userPO = new UserPO();
        BeanUtils.copyProperties(registerVO, userPO);
        Integer save = userDao.saveUser(userPO);
        return save != null && save > 0;
    }


}
