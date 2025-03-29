package org.skypro.courseworkJC.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    void testAddAndFindAllQuestions() {
        javaQuestionService.addQuestion("Что такое Java?", "Это язык программирования.");
        javaQuestionService.addQuestion("Что такое Spring Boot?", "Spring Boot — это полезный проект, целью которого является упрощение создания приложений на основе Spring.");

        assertEquals(2, javaQuestionService.findAllQuestions().size());
    }

    @Test
    void testRemoveQuestion() {
        javaQuestionService.addQuestion("Что такое Java?", "Это язык программирования.");
        javaQuestionService.removeQuestion("Что такое Spring Boot?", "Spring Boot — это полезный проект, целью которого является упрощение создания приложений на основе Spring.");

        assertEquals(0, javaQuestionService.findAllQuestions().size());
    }
}