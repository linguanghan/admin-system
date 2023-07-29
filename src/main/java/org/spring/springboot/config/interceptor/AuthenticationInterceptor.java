package org.spring.springboot.config.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.spring.springboot.common.anno.JwtIgnore;
import org.spring.springboot.util.JwtTokenUtil;
import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

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
public class AuthenticationInterceptor implements HandlerInterceptor {
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
        JwtTokenUtil.verifyToken(token);
        return true;
    }

}
