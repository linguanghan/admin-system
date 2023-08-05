package org.spring.springboot.dao.yldres;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.user.UserPO;
import org.spring.springboot.domain.yldres.active.DailyActiveUserLogPO;
import org.spring.springboot.domain.yldres.active.DailyActiveUserLogQuery;

import java.util.List;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-22 14:26
 */
public interface UserDao {
    /**
     *
     * 根据用户名查询用户信息
     * @author 13540
     * @date 2023-07-22 14:54 
     * @return java.util.List<org.spring.springboot.domain.yldres.active.DailyActiveUserLogPO>
     */
    UserPO fetchUseByUserName(@Param("userName")String userName);
    /**
     *
     * 保存
     * @author 13540
     * @date 2023-07-22 14:54 
     * @return java.lang.Integer
     */
    Integer saveUser(UserPO userPO);

    UserPO fetchUserById(Integer id);
}
