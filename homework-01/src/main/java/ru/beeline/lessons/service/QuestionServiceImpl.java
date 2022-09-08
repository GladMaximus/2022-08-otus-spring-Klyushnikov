package ru.beeline.lessons.service;

import ru.beeline.lessons.model.Question;

import java.io.Reader;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private final CsvService csvService;

    public QuestionServiceImpl(CsvService csvService) {
        this.csvService = csvService;
    }

    public List<Question> getQuestions(Reader reader) {
        return csvService.getAll(reader);
    }
}
