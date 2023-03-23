package org.spring.springboot.dao.game;

import org.spring.springboot.domain.game.Feedback;

import java.util.List;

public interface FeedbackDao {
    List<Feedback> fetchFeedback();
}
