package org.spring.springboot.service;

import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.game.vo.PageBookParamVO;
import org.spring.springboot.domain.res.Bookresource;

import java.util.List;

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

}
