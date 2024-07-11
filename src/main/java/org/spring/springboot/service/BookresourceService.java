package org.spring.springboot.service;

import org.spring.springboot.bean.Option;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.pelbsData.vo.PageBookParamVO;
import org.spring.springboot.domain.yldres.Bookresource;

import java.util.List;
import java.util.Map;

/**
 * Description
 *
 * @Author : zhoubin
 * @Date : 2023-01-21 18:58
 */
public interface BookresourceService {
    Result<?> fetchList(PageBookParamVO vo);

    List<Bookresource> fetchListByName(String name);

    List<Bookresource> fetchListByBookId(String bookId);

    List<Bookresource> searchBooklist(String name, String bookId, String keyword);

    void updateBookInfo(Bookresource bookInfo);

    void deleteBookInfo(Bookresource bookInfo);

    void saveBookInfo(Bookresource bookInfo);

    List<Option> queryBookResourceOptions();

    /**
     *
     * 根据课本id批量查询课本信息
     * @author 13540
     * @date 2023-09-24 16:56
     * @return java.util.Map<java.lang.Long, org.spring.springboot.domain.yldres.Bookresource>
     */
    Map<Long, Bookresource> fetchBookResourceByIds(List<Long> bookIds);

    Boolean setBookType();
}
