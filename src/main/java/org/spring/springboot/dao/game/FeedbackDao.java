package org.spring.springboot.dao.game;

import org.spring.springboot.domain.game.feedback.Feedback;

import java.util.List;

public interface FeedbackDao {
    List<Feedback> fetchFeedback();
}
