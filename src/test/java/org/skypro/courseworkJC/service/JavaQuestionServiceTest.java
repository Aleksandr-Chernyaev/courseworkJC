package org.skypro.courseworkJC.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skypro.courseworkJC.model.Question;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    void testAddAndFindAllQuestions() {
        javaQuestionService.addQuestion("What is Java?", "A programming language.");
        javaQuestionService.addQuestion("What is Spring?", "A framework.");

        assertEquals(2, javaQuestionService.findAllQuestions().size());
    }

    @Test
    void testRemoveQuestion() {
        javaQuestionService.addQuestion("What is Java?", "A programming language.");
        javaQuestionService.removeQuestion("What is Java?", "A programming language.");

        assertEquals(0, javaQuestionService.findAllQuestions().size());
    }
}