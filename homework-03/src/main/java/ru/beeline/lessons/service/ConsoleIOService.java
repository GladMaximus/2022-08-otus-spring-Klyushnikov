package ru.beeline.lessons.service;

import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Service
public class ConsoleIOService {
    private final Scanner userInput;

    private final PrintStream userOutput;

    public ConsoleIOService() {
        userInput = new Scanner(System.in, StandardCharsets.UTF_8);
        userOutput = new PrintStream(System.out, false, StandardCharsets.UTF_8);

    }

    public void outputString(String s){
        userOutput.println(s);
    }

    public String readString(){
        return userInput.nextLine();
    }
}
