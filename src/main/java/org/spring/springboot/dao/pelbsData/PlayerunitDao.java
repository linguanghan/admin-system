package org.spring.springboot.dao.pelbsData;

import generator.PlayerunitExample;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.pelbsData.PackageQuery;
import org.spring.springboot.domain.pelbsData.playerunit.Playerunit;

import java.util.List;

public interface PlayerunitDao {
    long countByExample(PlayerunitExample example);

    int deleteByExample(PlayerunitExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Playerunit record);

    int insertSelective(Playerunit record);

    List<Playerunit> selectByExample(PlayerunitExample example);

    List<Playerunit> selectByCondition(Playerunit playerunit);

    Playerunit selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Playerunit record, @Param("example") PlayerunitExample example);

    int updateByExample(@Param("record") Playerunit record, @Param("example") PlayerunitExample example);

    int updateByPrimaryKeySelective(Playerunit record);

    int updateByPrimaryKey(Playerunit record);

    /*--------------以下为自定义查询----------------*/
    // 绘本
    Integer findNumBetweenDate(@Param("startTime") Long startTime, @Param("endTime") Long endTime);
    List<Playerunit> findBetweenDate(@Param("startTime") Long startTime, @Param("endTime") Long endTime);
    // List<DayPlayer> findRegisterNumGroupbyDate(@Param("startTime") Long startTime, @Param("endTime") Long endTime);

    // 用户购买特定版本
    Integer findPurchaseNumBetweenDate(@Param("startTime") Long startTime, @Param("endTime") Long endTime);
    List<Playerunit> findPurchaseBetweenDate(@Param("startTime") Long startTime, @Param("endTime") Long endTime);

    // 特定版本
    Integer findVersionNumBetweenDate(@Param("startTime") Long startTime, @Param("endTime") Long endTime);
    List<Playerunit> findVersionBetweenDate(@Param("startTime") Long startTime, @Param("endTime") Long endTime);

    //根据用户id查询购买的书本
    List<Playerunit> findPlayerUnitByExample(Playerunit playerunit);

    List<Playerunit> queryRechargeByPage(@Param("startTime") Long startTime,
                                         @Param("endTime") Long endTime,
                                         @Param("pidList") List<Long> pidList,
                                         @Param("startRow") Integer startRow,
                                         @Param("pageSize") Integer pageSize,
                                         @Param("orderTime") Long orderTime,
                                         @Param("unlock") Integer unlock);


    Integer queryRechargeByPageCount(@Param("startTime") Long startTime,
                                     @Param("endTime") Long endTime,
                                     @Param("pidList") List<Long> pidList,
                                     @Param("orderTime") Long orderTime,
                                     @Param("unlock") Integer unlock);

    List<PackageQuery> queryPackageIdxRecharge(@Param("packageIdx") Long packageIdx, @Param("startTime") Long startTime, @Param("endTime") Long endTime);
    void updateBookPackageAndType(@Param("packageIdx") Integer packageIdx, @Param("bookIdx") Integer bookIdx, @Param("pid") Long pid, @Param("bookType") Integer bookType);


}