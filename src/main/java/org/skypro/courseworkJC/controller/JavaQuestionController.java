package org.skypro.courseworkJC.controller;

import org.skypro.courseworkJC.model.Question;
import org.skypro.courseworkJC.service.JavaQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    @Autowired
    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @PostMapping("/add")
    public String addQuestion(@RequestParam String question, @RequestParam String answer) {
        javaQuestionService.addQuestion(question, answer);
        return "Вопрос добавлен!";
    }

    @DeleteMapping("/remove")
    public String removeQuestion(@RequestParam String question, @RequestParam String answer) {
        javaQuestionService.removeQuestion(question, answer);
        return "Вопрос удален!";
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return javaQuestionService.findAllQuestions();
    }
}