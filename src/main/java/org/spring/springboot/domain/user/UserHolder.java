package org.spring.springboot.domain.user;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-08-05 10:58
 */
public class UserHolder {

    private static final ThreadLocal<UserHolderParam> userInfoHolder = new TransmittableThreadLocal();

    public static UserHolderParam getUser() {
        return userInfoHolder.get();
    }

    public static void setUser(UserHolderParam userHolderParam) {
        userInfoHolder.set(userHolderParam);
    }

    public static void clearUser() {
        userInfoHolder.set(null);
    }

    public static String getUserName() {
        UserHolderParam userInfo = getUser();
        if(userInfo == null) {
            return null;
        }
        return userInfo.getUserName();
    }

    public static Integer getRole() {
        UserHolderParam userInfo = getUser();
        if(userInfo == null) {
            return null;
        }
        return userInfo.getRole();
    }


}
