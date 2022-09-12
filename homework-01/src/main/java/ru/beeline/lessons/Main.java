package ru.beeline.lessons;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.beeline.lessons.model.Question;
import ru.beeline.lessons.service.QuestionService;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService service = context.getBean(QuestionService.class);


        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("questions.csv");

        Reader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        List<Question> questions = service.getQuestions(reader);
        if (questions != null) {
            int index = 1;
            for (Question question: questions) {
                System.out.println("Question " +  index + ": " + question.getName() + "\n");
                for (String answer: question.getAnswers()) {
                    System.out.println(answer + "\n");
                }
            index++;
            }
        } else {
            System.out.println("List questions is empty");
        }
    }
}
