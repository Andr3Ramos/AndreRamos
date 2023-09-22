package org.codeforall.studio.prompts.integer;

import org.codeforall.studio.InputPrompt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class IntegerInputPrompt implements InputPrompt<Integer> {

    private int charRead;

    private char[] data = new char[20];

    private String message;
    private String actualData="";

    public IntegerInputPrompt (String message)  {
        this.message = message;
    }

    @Override
    public void show(PrintStream output) {
        output.println(message);

    }

    @Override
    public void error(PrintStream output) {
        output.println("Invalid Integer Input.");

    }

    @Override
    public Integer getUserInput() {

        return Integer.parseInt(actualData);

        //throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasValidInput(BufferedReader input) throws IOException {

        charRead = input.read(data);

        for (int i = 0; i <charRead-1; i++) {  // needs to be charRead.length-1 because it reads the "OK PRESS" as a character (the last one...)
            actualData = actualData + data[i];
        }

        try {
            int intData = Integer.parseInt(actualData);
            return true;

        }  catch (NumberFormatException ex)  {
            actualData ="";
            return false;
        }

    }
}
