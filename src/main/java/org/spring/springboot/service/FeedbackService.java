package org.spring.springboot.service;

import com.github.pagehelper.PageInfo;
import org.spring.springboot.domain.game.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> fetchList();

    PageInfo<Feedback> selectAllPageQuery(int pageNum, int pageSize);
}
