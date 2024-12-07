package org.spring.springboot.controller;

import org.spring.springboot.common.anno.JwtIgnore;
import org.spring.springboot.domain.yldres.AppInfoConfig;
import org.spring.springboot.service.AppInfoConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appInfoConfig")
public class AppInfoConfigCtrl {

    @Autowired
    private AppInfoConfigService appInfoConfigService;

    /**
     * 获取包配置
     * @return
     */
    @JwtIgnore
    @GetMapping("/getMPkgInfo")
    public List<AppInfoConfig> getMPkgInfo() {
        return appInfoConfigService.findAll();
    }

    /**
     * 编辑
     * @param appInfoConfig
     * @return
     */
    @JwtIgnore
    @PutMapping("/update")
    public Integer updateAppInfoConfig(@RequestBody AppInfoConfig appInfoConfig) {
        return appInfoConfigService.update(appInfoConfig);
    }

    @GetMapping("/{id}")
    public AppInfoConfig getAppInfoConfigById(@PathVariable Integer id) {
        return appInfoConfigService.findById(id);
    }

    @PostMapping("/insert")
    public Integer createAppInfoConfig(@RequestBody AppInfoConfig appInfoConfig) {
        return appInfoConfigService.save(appInfoConfig);
    }

    @DeleteMapping("/{id}")
    public void deleteAppInfoConfig(@PathVariable Integer id) {
        appInfoConfigService.deleteById(id);
    }
}