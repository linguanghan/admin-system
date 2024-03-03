package org.spring.springboot.dao.pelbsData;

import org.spring.springboot.domain.pelbsData.feedback.Feedback;

import java.util.List;

public interface FeedbackDao {
    List<Feedback> fetchFeedback();
}
