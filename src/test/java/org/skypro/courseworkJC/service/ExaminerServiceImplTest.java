package org.skypro.courseworkJC.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.courseworkJC.model.Question;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExaminerServiceImplTest {
    private JavaQuestionService javaQuestionService;
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
        examinerService = new ExaminerServiceImpl(javaQuestionService);
    }

    @Test
    void testGetQuestions() {
        javaQuestionService.addQuestion("Что такое Java?", "Это язык программирования.");
        javaQuestionService.addQuestion("Что такое Spring?", "Это фреймворк.");

        List<Question> questions = examinerService.getQuestions(1);
        assertEquals(1, questions.size());
    }

    @Test
    void testGetQuestionsNotEnough() {
        javaQuestionService.addQuestion("Что такое Java?", "Это язык программирования.");

        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            examinerService.getQuestions(2);
        });

        assertEquals("400 BAD_REQUEST \"Not enough questions available\"", exception.getMessage());
    }
}