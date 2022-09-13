package ru.beeline.lessons.model;

public class Question {

    private final String name;

    private final String options;

    private final String answer;

    public Question(String name, String options, String answer) {
        this.name = name;
        this.options = options;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public String getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }
}
