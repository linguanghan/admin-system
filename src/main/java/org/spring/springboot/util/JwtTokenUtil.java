package org.spring.springboot.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.spring.springboot.common.enums.BusiCodeEnum;
import org.spring.springboot.common.exception.ServiceException;

import java.util.Date;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-29 15:44
 */
public class JwtTokenUtil {
    //定义token返回头部
    public static final String AUTH_HEADER_KEY = "accessToken";

    //token前缀
    public static final String TOKEN_PREFIX = "Bearer ";

    //签名密钥
    public static final String KEY = "q3t6w9z$C&F)J@NcQfTjWnZr4u7x";

    //有效期默认为 2hour
    public static final Long EXPIRATION_TIME = 1000L*60*60*2;

    /**
     *
     * 创建token
     * @param content
     * @author 13540
     * @date 2023-07-29 15:47 
     * @return java.lang.String
     */
    public static String createToken(String content) {
        return TOKEN_PREFIX + JWT.create()
                .withSubject(content)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(KEY));
    }

    /**
     *
     * 验证token
     * @author 13540
     * @date 2023-07-29 15:52
     * @return java.lang.String
     */
    public static String verifyToken(String token) throws Exception{
        try {
            return JWT.require(Algorithm.HMAC512(KEY))
                    .build()
                    .verify(token.replace(TOKEN_PREFIX, ""))
                    .getSubject();
        }catch (TokenExpiredException e) {
            throw new ServiceException(BusiCodeEnum.LOGIN_OUT_OF_TIME);
        }catch (JWTVerificationException e) {
            throw new ServiceException(BusiCodeEnum.LOGIN_ERROR);
        }
    }

}
