package org.spring.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.dao.game.FeedbackDao;
import org.spring.springboot.domain.game.Feedback;
import org.spring.springboot.service.FeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private static final

    Logger LOGGER = LoggerFactory.getLogger(FeedbackServiceImpl.class);

   @Resource
    private FeedbackDao feedbackDao;

    @Override
    public List<Feedback> fetchList() {
        return feedbackDao.fetchFeedback();
    }

    @Override
    public PageInfo<Feedback> selectAllPageQuery(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Feedback> list = fetchList();
        PageInfo<Feedback> result = new PageInfo<>(list);
        return result;
    }
}
