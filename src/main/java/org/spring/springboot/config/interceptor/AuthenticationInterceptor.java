package org.spring.springboot.config.interceptor;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.spring.springboot.common.anno.JwtIgnore;
import org.spring.springboot.domain.user.*;
import org.spring.springboot.service.UserService;
import org.spring.springboot.util.JwtTokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-29 15:55
 */
@Slf4j
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从http请求头中取出token
        final String token = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        // 如果不是映射方法。直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        //如果方法有JwtIgnore注解，直接通过
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method=handlerMethod.getMethod();
        if (method.isAnnotationPresent(JwtIgnore.class)) {
            JwtIgnore jwtIgnore = method.getAnnotation(JwtIgnore.class);
            if(jwtIgnore != null){
                return true;
            }
        }

        if(StringUtils.isEmpty(token)) {
            log.error("AuthenticationInterceptor#preHandle token为空，鉴权失败！");
            return false;
        }
        //验证，并获取token内部信息
        String tokenStr = JwtTokenUtil.verifyToken(token);
        //设置登录态的用户信息
        setUserHolderFromToken(tokenStr);
        return true;
    }

    /**
     *
     * 设置登录态的用户信息
     * @author 13540
     * @date 2023-08-05 11:19 
     * @return void
     */
    private void setUserHolderFromToken(String tokenStr) {
        UserToken userToken = JSON.parseObject(tokenStr, UserToken.class);
        UserPO userPO = userService.getUserInfoById(userToken.getId());
        UserHolderParam userHolderParam = new UserHolderParam();
        BeanUtils.copyProperties(userPO, userHolderParam);
        UserHolder.setUser(userHolderParam);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        UserHolder.clearUser();
    }
}
