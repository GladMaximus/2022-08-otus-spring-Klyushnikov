package ru.beeline.lessons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.beeline.lessons.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final CsvService csvService;

    @Value("${passing.count}")
    private String passingCount;

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

    @Override
    public void startExam() {
        List<Question> questions = getQuestions();

        Scanner sc = new Scanner(System.in);

        if (questions != null) {
            System.out.println("Enter your name:");
            String studentName = sc.nextLine();

            int index = 0;
            int countCorrectAnswer = 0;
            for (Question question : questions) {
                System.out.println("Question " + (index + 1) + ": " + question.getName());

                if (question.getOptions() != null && !question.getOptions().isBlank()) {
                    System.out.println("Answer options: " + question.getOptions());
                    System.out.println("Choose 1 answer.  Enter an answer without a dot\n");
                } else {
                    System.out.println("Enter an answer without a dot\n");

                }
                String studentAnswer = sc.nextLine();
                if (question.getAnswer().trim().equalsIgnoreCase(studentAnswer.trim())) {
                    countCorrectAnswer++;
                    System.out.println("Correct answer!\n");

                } else {
                    System.out.println("Wrong answer!\n");
                }
                index++;
            }

            if (countCorrectAnswer >= Integer.parseInt(passingCount)) {
                System.out.println("Congratulations! " + studentName + ", you passed the exam");
            } else {
                System.out.println(studentName + ", you didn't pass the exam");
            }
        } else {
            System.out.println("List questions is empty");
        }
        sc.close();
    }
}
