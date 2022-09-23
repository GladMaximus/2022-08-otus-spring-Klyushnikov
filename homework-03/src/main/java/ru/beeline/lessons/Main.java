package ru.beeline.lessons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.beeline.lessons.configs.AppProps;
import ru.beeline.lessons.service.ConsoleIOService;
import ru.beeline.lessons.service.CsvServiceImpl;
import ru.beeline.lessons.service.ExamServiceImpl;
import ru.beeline.lessons.service.QuestionServiceImpl;

@SpringBootApplication
@EnableConfigurationProperties(AppProps.class)
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        new ExamServiceImpl(new QuestionServiceImpl(new CsvServiceImpl()),
                new ConsoleIOService(), new AppProps())
                .startExam();

    }
}
