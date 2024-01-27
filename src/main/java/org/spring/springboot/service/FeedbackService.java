package org.spring.springboot.service;

import com.github.pagehelper.PageInfo;
import org.spring.springboot.domain.game.feedback.FeedBackVO;
import org.spring.springboot.domain.game.feedback.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> fetchList();

    PageInfo<FeedBackVO> selectAllPageQuery(int pageNum, int pageSize);
}
