package ru.beeline.lessons.service;

import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Service
public class ConsoleIOServiceImpl implements ConsoleIOService{
    private final Scanner userInput;

    private final PrintStream userOutput;

    public ConsoleIOServiceImpl() {
        userInput = new Scanner(System.in, StandardCharsets.UTF_8);
        userOutput = new PrintStream(System.out, false, StandardCharsets.UTF_8);

    }

    @Override
    public void outputString(String s){
        userOutput.println(s);
    }

    @Override
    public String readString(){
        return userInput.nextLine();
    }
}
