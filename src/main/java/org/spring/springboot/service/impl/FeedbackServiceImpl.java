package org.spring.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.dao.pelbsData.FeedbackDao;
import org.spring.springboot.dao.yldres.AppInfoConfigDao;
import org.spring.springboot.domain.pelbsData.feedback.FeedBackVO;
import org.spring.springboot.domain.pelbsData.feedback.Feedback;
import org.spring.springboot.domain.yldres.app.AppInfoConfig;
import org.spring.springboot.service.FeedbackService;
import org.spring.springboot.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private static final

    Logger LOGGER = LoggerFactory.getLogger(FeedbackServiceImpl.class);

    private static final String LENGTH_10 = "LENGTH_10";

    @Resource
    private FeedbackDao feedbackDao;

    @Resource
    private AppInfoConfigDao appInfoConfigDao;

    @Override
    public List<Feedback> fetchList() {
        return feedbackDao.fetchFeedback();
    }

    @Override
    public PageInfo<FeedBackVO> selectAllPageQuery(int pageNum, int pageSize) {
        PageHelper.startPage(1, Integer.MAX_VALUE);
        int total = fetchList().size();

        PageHelper.startPage(pageNum, pageSize);
        List<Feedback> feedbacks = fetchList();
        if(CollectionUtils.isEmpty(feedbacks)) {
            return new PageInfo<>(Collections.emptyList());
        }

        // 查询appName
        List<AppInfoConfig> appInfoConfigs = appInfoConfigDao.selectAll();
        Map<Integer, String> map = appInfoConfigs.stream()
                .collect(Collectors.toMap(
                        AppInfoConfig::getPackageIdx,
                        AppInfoConfig::getAppName,
                        (existing, replacement) -> existing // 保留第一个出现的appName
                ));

        List<FeedBackVO> feedBackVOS = feedbacks.stream().map(feedback -> {
            FeedBackVO feedBackVO = new FeedBackVO();
            BeanUtils.copyProperties(feedback, feedBackVO);
            if(feedback.getTime() == null || feedback.getTime() == 0) {
                return feedBackVO;
            }
            Date date = DateUtil.timeStampToDate(feedback.getTime(), LENGTH_10);
            feedBackVO.setTime(date);
            feedBackVO.setAppName(map.get(feedback.getPackageidx()));
            return feedBackVO;
        }).collect(Collectors.toList());

        PageInfo<FeedBackVO> pageInfo = new PageInfo<>(feedBackVOS);
        pageInfo.setTotal(total);
        return pageInfo;
    }
}
