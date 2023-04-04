package org.spring.springboot.controller;

import org.spring.springboot.bean.AjaxResult;
import org.spring.springboot.domain.game.PlayerAgentInfo;
import org.spring.springboot.service.PlayerAgentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("agentInfo")
public class PlayerAgentInfoCtrl {
    @Autowired
    private PlayerAgentInfoService playerAgentInfoService;

    // 查询所有agentInfo
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public AjaxResult findAgentList(){
        return AjaxResult.successResult(playerAgentInfoService.fetchList());
    }

    // 更改state状态
    @RequestMapping(value = "/update/state", method = RequestMethod.GET)
    public AjaxResult updateAgentState(@RequestParam("id") String id, @RequestParam("state") String state){
        PlayerAgentInfo playerAgentInfo = new PlayerAgentInfo();
        playerAgentInfo.setId(Long.parseLong(id));
        playerAgentInfo.setState(Integer.parseInt(state));
        playerAgentInfoService.updateAgentState(playerAgentInfo);
        return AjaxResult.emptySuccessResult();
    }
}
