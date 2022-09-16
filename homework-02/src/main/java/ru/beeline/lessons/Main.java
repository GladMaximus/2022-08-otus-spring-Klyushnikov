package ru.beeline.lessons;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import ru.beeline.lessons.service.QuestionService;

@ComponentScan
@PropertySource("application.properties")
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        QuestionService service = context.getBean(QuestionService.class);

        service.startExam();

    }
}
