package org.spring.springboot.controller;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.bean.AjaxResult;
import org.spring.springboot.common.anno.JwtIgnore;
import org.spring.springboot.common.enums.SysCodeEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.game.vo.PageBookParamVO;
import org.spring.springboot.domain.yldres.Bookresource;
import org.spring.springboot.service.BookresourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description
 *
 * @Author : zhoubin
 * @Date : 2023-01-16 22:45
 */
@RestController
@RequestMapping("book/resource")
public class BookresourceCtrl {

    private static final Logger logger = LoggerFactory.getLogger(BookresourceCtrl.class);
    @Autowired
    private BookresourceService bookresourceService;

    // 查询书本列表
    @RequestMapping(value = "/list")
    public Result<?> findBooklist(PageBookParamVO vo) {
        try {
            return bookresourceService.fetchList(vo);
        }catch (Exception e) {
            logger.error("BookresourceCtrl#findBooklist error vo is{}", JSONUtil.toJsonStr(vo), e);
            return Result.buildFailure(SysCodeEnum.SysError);
        }
    }

    // 查询书本列表--按名称搜索
    @RequestMapping(value = "/list/name", method = RequestMethod.GET)
    public AjaxResult findBooklistByname(String name) {
        return AjaxResult.successResult(bookresourceService.fetchListByName(name));
    }

    // 查询书本列表--按编号搜索
    @RequestMapping(value = "/list/bookId", method = RequestMethod.GET)
    public AjaxResult findBooklistByBookId(String bookId) {
        return AjaxResult.successResult(bookresourceService.fetchListByBookId(bookId));
    }

    // 查询书本列表--按编号或名称搜索
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @JwtIgnore
    public AjaxResult searchBooklist(String name,String bookId,String keyword) {
        return AjaxResult.successResult(bookresourceService.searchBooklist(name,bookId,keyword));
    }

    // 编辑书本信息
    @RequestMapping(value = "/update/info", method = RequestMethod.POST)
    public AjaxResult updateBookinfo(@RequestBody Bookresource bookInfo) {
        bookresourceService.updateBookInfo(bookInfo);
        return AjaxResult.emptySuccessResult();
    }

    // 删除书本信息
    @RequestMapping(value = "/del/info", method = RequestMethod.POST)
    public AjaxResult deleteBookinfo(@RequestBody Bookresource bookInfo) {
        bookresourceService.deleteBookInfo(bookInfo);
        return AjaxResult.emptySuccessResult();
    }

    // 新增书本信息
    @RequestMapping(value = "/save/info", method = RequestMethod.POST)
    public AjaxResult saveBookinfo(@RequestBody Bookresource bookInfo) {
        bookresourceService.saveBookInfo(bookInfo);
        return AjaxResult.emptySuccessResult();
    }

    /**
     *
     * 获取书本信息的下拉列表
     * @author 13540
     * @date 2023-09-17 16:38
     * @return org.spring.springboot.common.result.Result<?>
     */
    @RequestMapping(value = "/queryBookResourceOptions", method = RequestMethod.GET)
    public Result<?> queryBookResourceOptions() {
        try {
          return Result.buildSuccess().add("data", bookresourceService.queryBookResourceOptions());
        }catch (Exception e) {
            logger.error("BookresourceCtrl#queryBookResourceOptions error e", e);
        }
        return Result.buildFailure();
    }

}
