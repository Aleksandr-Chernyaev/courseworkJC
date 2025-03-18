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
        javaQuestionService.addQuestion("What is Java?", "A programming language.");
        javaQuestionService.addQuestion("What is Spring?", "A framework.");

        List<Question> questions = examinerService.getQuestions(1);
        assertEquals(1, questions.size());
    }

    @Test
    void testGetQuestionsNotEnough() {
        javaQuestionService.addQuestion("What is Java?", "A programming language.");

        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            examinerService.getQuestions(2);
        });

        assertEquals("404 NOT_FOUND \"Not enough questions available\"", exception.getMessage());
    }
}