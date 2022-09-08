package ru.beeline.lessons.service;

import ru.beeline.lessons.model.Question;

import java.io.Reader;
import java.util.List;

public interface CsvService {

    List<Question> getAll(Reader reader);
}
