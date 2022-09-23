package ru.beeline.lessons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.beeline.lessons.model.Question;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final CsvService csvService;

    @Autowired
    public QuestionServiceImpl(CsvService csvService) {
        this.csvService = csvService;
    }

    @Override
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        List<String[]> allRows = csvService.getAll();
        for (String[] row : allRows) {
            questions.add(new Question(row[0], row[1], row[2]));
        }
        return questions;
    }
}
