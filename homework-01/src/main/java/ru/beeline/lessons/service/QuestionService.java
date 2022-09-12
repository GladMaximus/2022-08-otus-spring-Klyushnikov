package ru.beeline.lessons.service;

import ru.beeline.lessons.model.Question;

import java.io.Reader;
import java.util.List;

public interface QuestionService {

    List<Question> getQuestions(Reader reader);
}
