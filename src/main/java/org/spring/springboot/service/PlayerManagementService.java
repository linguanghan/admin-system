/**
 * @projectName: admin-system
 * @package: org.spring.springboot.service
 * @InterfaceName: PlayerManagementService
 * @author: Chen Dehong
 * @description: 定义对新数据库表进行业务逻辑处理的方法
 * @date: 2/4/2024 11:43 AM
 * @version: 1.0
 */
package org.spring.springboot.service;

import org.spring.springboot.bean.Option;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.pelbsData.PlayerManagement;
import org.spring.springboot.domain.pelbsData.vo.PagePlayerParamVO;

import java.util.List;
import java.util.Map;

public interface PlayerManagementService {
    Result<?> fetchList(PagePlayerParamVO vo);

    List<PlayerManagement> fetchListByName(String name);

    List<PlayerManagement> fetchListByPlayerId(String playerId);

    List<PlayerManagement> searchPlayerlist(String name, String playerId, String keyword);

    void updatePlayerInfo(PlayerManagement playerInfo);

    void deletePlayerInfo(PlayerManagement playerInfo);

    String savePlayerManagementInfo(PlayerManagement playerInfo);

    List<Option> queryPlayerResourceOptions();

    Map<Long, PlayerManagement> fetchPlayerResourceByIds(List<Long> playerIds);
}
