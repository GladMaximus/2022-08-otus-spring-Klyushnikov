package ru.beeline.lessons.service;


import au.com.bytecode.opencsv.CSVReader;
import ru.beeline.lessons.model.Question;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvServiceImpl implements CsvService{

    @Override
    public List<Question> getAll(Reader reader) {
        List<Question> questions = new ArrayList<>();
        CSVReader csvReader = new CSVReader(reader, ',');
        try {
            List<String[]> allRows = csvReader.readAll();
            for(String[] row : allRows){
                List<String> answers = new ArrayList<>();

                if (row.length > 1) {
                    answers = Arrays.asList(Arrays.copyOfRange(row, 1, row.length));
                }
                questions.add(new Question(row[0], answers));
            }
            return questions;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
