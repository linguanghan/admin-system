package org.spring.springboot.service.impl;

import cn.hutool.core.collection.ListUtil;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.dao.res.BookresourceDao;
import org.spring.springboot.domain.game.vo.PageBookParamVO;
import org.spring.springboot.domain.res.Bookresource;
import org.spring.springboot.service.BookresourceService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Description
 *
 * @Author : zhoubin
 * @Date : 2023-01-21 18:58
 */
@Service
public class BookresourceImpl implements BookresourceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookresourceImpl.class);

    private static final String FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String time_start_suffix = " 00:00:00";
    private static final String time_end_suffix = " 23:59:59";

    @Resource
    private BookresourceDao bookresourceDao;

    @Override
    public Result<?> fetchList(PageBookParamVO vo) {
        List<Bookresource> bookResources = Collections.emptyList();
        if (StringUtils.isEmpty(vo.getBookName()) && StringUtils.isEmpty(vo.getBookId())) {
            bookResources = bookresourceDao.fetchBookresourceInfos();
        }

        if (!StringUtils.isEmpty(vo.getBookName()) && StringUtils.isEmpty(vo.getBookId())) {
            bookResources = bookresourceDao.fetchBookresourceInfosByName(vo.getBookName());
        }

        if(StringUtils.isEmpty(vo.getBookName()) && !StringUtils.isEmpty(vo.getBookId())) {
            bookResources = bookresourceDao.fetchBookresourceInfosByBookId(vo.getBookId());
        }

        return Result.buildSuccess().add("data", ListUtil.page(vo.getPageNo() - 1, vo.getPageSize(), bookResources)).add("total", bookResources.size());

    }

    @Override
    public List<Bookresource> fetchListByName(String name) {
        return bookresourceDao.fetchBookresourceInfosByName(name);
    }

    @Override
    public List<Bookresource> fetchListByBookId(String bookId) {
        return bookresourceDao.fetchBookresourceInfosByBookId(bookId);
    }

    @Override
    public List<Bookresource> searchBooklist(String name, String bookId, String keyword) {
        if (!Strings.isBlank(name)){
            return bookresourceDao.fetchBookresourceInfosByName(name);
        }else if (!Strings.isBlank(bookId)){
            return bookresourceDao.fetchBookresourceInfosByBookId(bookId);
        }else if (!Strings.isBlank(keyword)){
            return bookresourceDao.searchBooklist(keyword);
        }
        return null;
    }

    @Override
    public void updateBookInfo(Bookresource bookInfo) {
        bookresourceDao.updateBookInfo(bookInfo);
    }

    @Override
    public void deleteBookInfo(Bookresource bookInfo) {
        bookresourceDao.deleteBookInfo(bookInfo);
    }

    @Override
    public void saveBookInfo(Bookresource bookInfo) {
        bookresourceDao.saveBookInfo(bookInfo);
    }

}
