package ru.beeline.lessons.service;


import au.com.bytecode.opencsv.CSVReader;
import org.springframework.stereotype.Service;
import ru.beeline.lessons.Main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class CsvServiceImpl implements CsvService {

    @Override
    public List<String[]> getAll() {
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("questions.csv");
        Reader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        CSVReader csvReader = new CSVReader(reader, ';');
        try {
            return csvReader.readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
