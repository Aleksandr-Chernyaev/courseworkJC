package org.skypro.courseworkJC.service;

import org.skypro.courseworkJC.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExaminerService {
    List<Question> getQuestions(int amount);
}