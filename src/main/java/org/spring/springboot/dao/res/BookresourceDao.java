package org.spring.springboot.dao.res;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.res.Bookresource;

import java.util.List;

/**
 * Description
 *
 * @Author : zhoubin
 * @Date : 2023-01-16 21:53
 */
public interface BookresourceDao {
    List<Bookresource> fetchBookresourceInfos();

    List<Bookresource> fetchBookresourceInfosByName(@Param("name") String name);

    List<Bookresource> fetchBookresourceInfosByBookId(@Param("bookId") String bookId);

    List<Bookresource> searchBooklist(@Param("keyword") String keyword);

    void updateBookInfo(Bookresource bookInfo);

    void deleteBookInfo(Bookresource bookInfo);

    void saveBookInfo(Bookresource bookInfo);


}
