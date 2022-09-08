package ru.beeline.lessons.model;

import java.util.List;

public class Question {

    private final String name;

    private final List<String> answers;

    public Question(String name, List<String> answers) {
        this.name = name;
        this.answers = answers;
    }

    public String getName() {
        return name;
    }

    public List<String> getAnswers() {
        return answers;
    }
}
