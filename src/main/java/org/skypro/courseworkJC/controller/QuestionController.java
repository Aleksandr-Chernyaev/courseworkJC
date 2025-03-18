package org.skypro.courseworkJC.controller;

import org.skypro.courseworkJC.model.Question;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exam")
public class QuestionController {
    private final List<Question> questions = new ArrayList<>();

    @PostMapping("/add")
    public String addQuestion(@RequestParam String question, @RequestParam String answer) {
        questions.add(new Question(question, answer));
        return "Question added successfully!";
    }

    @GetMapping("/all")
    public List<Question> getAllQuestions() {
        return questions;
    }
}