package org.spring.springboot.service.impl;

import cn.hutool.core.collection.ListUtil;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.bean.Option;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.dao.pelbsData.PlayerunitDao;
import org.spring.springboot.dao.yldres.BookresourceDao;
import org.spring.springboot.domain.pelbsData.vo.PageBookParamVO;
import org.spring.springboot.domain.yldres.Bookresource;
import org.spring.springboot.service.BookresourceService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

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

    static Map<String, Integer> gradeCodeMap = new HashMap<>();

    static {
        gradeCodeMap.put("一年级上册", 11);
        gradeCodeMap.put("一年级下册", 12);
        gradeCodeMap.put("二年级上册", 21);
        gradeCodeMap.put("二年级下册", 22);
        gradeCodeMap.put("三年级上册", 31);
        gradeCodeMap.put("三年级下册", 32);
        gradeCodeMap.put("四年级上册", 41);
        gradeCodeMap.put("四年级下册", 42);
        gradeCodeMap.put("五年级上册", 51);
        gradeCodeMap.put("五年级下册", 52);
        gradeCodeMap.put("六年级上册", 61);
        gradeCodeMap.put("六年级下册", 62);
        gradeCodeMap.put("七年级上册", 71);
        gradeCodeMap.put("七年级下册", 72);
        gradeCodeMap.put("八年级上册", 81);
        gradeCodeMap.put("八年级下册", 82);
        gradeCodeMap.put("九年级上册", 91);
        gradeCodeMap.put("九年级下册", 92);
        gradeCodeMap.put("一年级数学上册", 11);
        gradeCodeMap.put("一年级数学下册", 12);
        gradeCodeMap.put("二年级数学上册", 21);
        gradeCodeMap.put("二年级数学下册", 22);
        gradeCodeMap.put("三年级数学上册", 31);
        gradeCodeMap.put("三年级数学下册", 32);
        gradeCodeMap.put("四年级数学上册", 41);
        gradeCodeMap.put("四年级数学下册", 42);
        gradeCodeMap.put("五年级数学上册", 51);
        gradeCodeMap.put("五年级数学下册", 52);
        gradeCodeMap.put("六年级数学上册", 61);
        gradeCodeMap.put("六年级数学下册", 62);
        gradeCodeMap.put("七年级数学上册", 71);
        gradeCodeMap.put("七年级数学下册", 72);
        gradeCodeMap.put("八年级数学上册", 81);
        gradeCodeMap.put("八年级数学下册", 82);
        gradeCodeMap.put("九年级数学上册", 91);
        gradeCodeMap.put("九年级数学下册", 92);
    }

    @Resource
    private BookresourceDao bookresourceDao;

    @Resource
    private PlayerunitDao playerunitDao;

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

    @Override
    public List<Option> queryBookResourceOptions() {
        List<Bookresource> bookresources = bookresourceDao.fetchBookresourceInfos();
        if(CollectionUtils.isEmpty(bookresources)) {
            return Collections.emptyList();
        }
        return bookresources.stream().map(bookresource -> {
            Option option = new Option();
            option.setLabel("【" + bookresource.getBookId() + "】" + bookresource.getName());
            option.setValue(String.valueOf(bookresource.getBookId()));
            return option;
        }).collect(Collectors.toList());
    }

    @Override
    public Map<Long, Bookresource> fetchBookResourceByIds(List<Long> bookIds) {
        List<Bookresource> bookresources = bookresourceDao.batchQueryBookResourceInfosByIds(bookIds);
        if(CollectionUtils.isEmpty(bookresources)) {
            return new HashMap<>();
        }
        return bookresources.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Bookresource::getBookId, v->v, (k1,k2)->k1));
    }

    @Override
    public Boolean setBookType() {
        List<Bookresource> bookresources = bookresourceDao.fetchBookresourceInfos();
        if(CollectionUtils.isEmpty(bookresources)) {
            return true;
        }

        bookresources.forEach(bookresource -> {
            String name = bookresource.getName();
            String s = nameContainGradeString(name);
            if (s != null) {
                bookresource.setBookType(gradeCodeMap.get(s));
            }
            else {
                bookresource.setBookType(0);
            }
            bookresourceDao.updateBookInfo(bookresource);
        });
        return true;
    }

    private String nameContainGradeString(String name) {
        if(StringUtils.isEmpty(name)) {
            return null;
        }
        Set<String> gradeStringSet = gradeCodeMap.keySet();
        for (String s : gradeStringSet) {
            if(name.contains(s)) {
                return s;
            }
        }
        return null;
    }

}
