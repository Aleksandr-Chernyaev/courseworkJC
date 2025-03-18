package org.skypro.courseworkJC.service;

import org.skypro.courseworkJC.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private final List<Question> questions = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public void addQuestion(String question, String answer) {
        questions.add(new Question(question, answer));
    }

    @Override
    public void removeQuestion(String question, String answer) {
        questions.removeIf(q -> q.getQuestion().equals(question) && q.getAnswer().equals(answer));
    }

    @Override
    public List<Question> findAllQuestions() {
        return new ArrayList<>(questions);
    }

    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            return null; // или выбросьте исключение
        }
        int index = random.nextInt(questions.size());
        return questions.get(index);
    }
}