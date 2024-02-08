/**
 * @projectName: admin-system
 * @package: org.spring.springboot.domain.pelbs_data
 * @InterfaceName: PlayerManagementDao
 * @author: Chen Dehong
 * @description: 定义对数据库表进行操作的方法。
 * @date: 2/4/2024 11:39 AM
 * @version: 1.0
 */
package org.spring.springboot.dao.pelbsData;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.pelbsData.PlayerManagement;

import java.util.List;

public interface PlayerManagementDao {
    List<PlayerManagement> fetchPlayerManagementInfos();

    List<PlayerManagement> fetchPlayerManagementInfosByName(@Param("agentName") String name);

    List<PlayerManagement> fetchPlayerManagementInfosByPlayerId(@Param("agentPid") String playerId);

    List<PlayerManagement> searchPlayerlist(@Param("keyword") String keyword);

    void updatePlayerManagementInfo(PlayerManagement playerInfo);

    void updatePlayerIdentityInfo(PlayerManagement playerInfo);

    void deletePlayerManagementInfo(PlayerManagement playerInfo);

    void deletePlayerIdentityInfo(PlayerManagement playerInfo);

    void savePlayerManagementInfo(PlayerManagement playerInfo);

    void savePlayerIdentityInfo(PlayerManagement playerInfo);
    
    List<PlayerManagement> batchQueryPlayerManagementInfosByIds(@Param("playerIdx") List<Long> playerIdx);
    
}