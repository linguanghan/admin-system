package org.spring.springboot.dao.yldres;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.yldres.Bookresource;

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

    /**
     *
     * 批量查询书本信息
     * @param bookIdx
     * @author 13540
     * @date 2023-09-03 14:59
     * @return java.util.List<org.spring.springboot.domain.yldres.Bookresource>
     */
    List<Bookresource> batchQueryBookResourceInfosByIds(@Param("bookIdx") List<Long> bookIdx);


}
