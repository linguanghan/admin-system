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
    @RequestMapping(value = "/update/state", method = RequestMethod.POST)
    public AjaxResult updateAgentState(@RequestBody PlayerAgentInfo playerAgentInfo){
        playerAgentInfoService.updateAgentState(playerAgentInfo);
        return AjaxResult.emptySuccessResult();
    }
}
