package org.spring.springboot.controller;

import org.spring.springboot.bean.AjaxResult;
import org.spring.springboot.domain.res.Bookresource;
import org.spring.springboot.service.BookresourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 *
 * @Author : zhoubin
 * @Date : 2023-01-16 22:45
 */
@RestController
@RequestMapping("book/resource")
public class BookresourceCtrl {
    @Autowired
    private BookresourceService bookresourceService;

    // 查询书本列表
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public AjaxResult findBooklist() {
        return AjaxResult.successResult(bookresourceService.fetchList());
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

}
