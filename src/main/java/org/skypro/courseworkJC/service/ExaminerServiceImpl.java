package org.skypro.courseworkJC.service;

import org.skypro.courseworkJC.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;

    @Autowired
    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        List<Question> allQuestions = javaQuestionService.findAllQuestions();
        if (amount > allQuestions.size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough questions available");
        }

        Set<Question> uniqueQuestions = new HashSet<>();
        while (uniqueQuestions.size() < amount) {
            uniqueQuestions.add(javaQuestionService.getRandomQuestion());
        }
        return List.copyOf(uniqueQuestions);
    }
}