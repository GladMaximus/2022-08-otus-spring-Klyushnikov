package ru.beeline.lessons.service;

import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Service
public interface ConsoleIOService {

    void outputString(String s);

    String readString();
}
