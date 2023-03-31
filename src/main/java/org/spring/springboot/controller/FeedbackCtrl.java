package org.spring.springboot.controller;

import com.github.pagehelper.PageInfo;
import org.spring.springboot.bean.AjaxResult;
import org.spring.springboot.domain.game.Feedback;
import org.spring.springboot.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feedback")
public class FeedbackCtrl {

    @Autowired
    private FeedbackService feedbackService;

    // 查询评价列表
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public AjaxResult findFeedbackList(){
        return AjaxResult.successResult(feedbackService.fetchList());
    }

    // 接口路径：/feedback/selectAllPageQuery??pageNum=1&pageSize=50
    // 分页查询
    @RequestMapping(value = "/selectAllPageQuery", method = RequestMethod.GET)
    public AjaxResult selectAllPageQuery(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        return AjaxResult.successResult(feedbackService.selectAllPageQuery(pageNum, pageSize));
    }
}
