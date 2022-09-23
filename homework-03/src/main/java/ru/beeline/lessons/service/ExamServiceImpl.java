package ru.beeline.lessons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.beeline.lessons.configs.AppProps;
import ru.beeline.lessons.model.Question;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService{

    private final QuestionService questionService;

    private final ConsoleIOService consoleIOService;
    
    private final AppProps appProps;

    @Autowired
    public ExamServiceImpl(QuestionService questionService, ConsoleIOService consoleIOService, AppProps appProps) {
        this.questionService = questionService;
        this.consoleIOService = consoleIOService;
        this.appProps = appProps;
    }

    @Override
    public void startExam() {
        List<Question> questions = questionService.getQuestions();
        
        if (questions != null) {
            consoleIOService.outputString("Введите фамилию и имя:");
            String studentName = consoleIOService.readString();

            int index = 0;
            int countCorrectAnswer = 0;
            for (Question question : questions) {
                consoleIOService.outputString("Вопрос " + (index + 1) + ": " + question.getName());

                if (question.getOptions() != null && !question.getOptions().isBlank()) {
                    consoleIOService.outputString("Варианты ответов: " + question.getOptions());
                    consoleIOService.outputString("Выберите 1 вариант. Введите номер ответа без точки\n");
                } else {
                    consoleIOService.outputString("Введите ответ без точки\n");

                }
                String studentAnswer = consoleIOService.readString();
                if (question.getAnswer().trim().equalsIgnoreCase(studentAnswer.trim())) {
                    countCorrectAnswer++;
                    consoleIOService.outputString("Правильный ответ!\n");

                } else {
                    consoleIOService.outputString("Неправильный ответ!\n");
                }
                index++;
            }

            checkPass(countCorrectAnswer, studentName);
        } else {
            consoleIOService.outputString("List questions is empty");
        }
    }

    private void checkPass(int countCorrectAnswer, String studentName) {
        if (countCorrectAnswer >= appProps.getPassing()) {
            consoleIOService.outputString("Поздравляем, " + studentName + ", вы сдали экзамен");
        } else {
            consoleIOService.outputString(studentName + ", вы не сдали экзамен");
        }
    }
}
