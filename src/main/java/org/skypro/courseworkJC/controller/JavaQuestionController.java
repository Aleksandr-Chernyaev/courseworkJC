package org.skypro.courseworkJC.controller;

import org.skypro.courseworkJC.service.JavaQuestionService;
import org.skypro.courseworkJC.model.Question;
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
        return "Question added successfully!";
    }

    @DeleteMapping("/remove")
    public String removeQuestion(@RequestParam String question, @RequestParam String answer) {
        javaQuestionService.removeQuestion(question, answer);
        return "Question removed successfully!";
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return javaQuestionService.findAllQuestions();
    }
}