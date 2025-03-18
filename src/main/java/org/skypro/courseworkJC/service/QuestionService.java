package org.skypro.courseworkJC.service;

import org.skypro.courseworkJC.model.Question;

import java.util.List;

public interface QuestionService {
    void addQuestion(String question, String answer);
    void removeQuestion(String question, String answer);
    List<Question> findAllQuestions();
}