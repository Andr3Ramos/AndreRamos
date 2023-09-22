package org.codeforall.studio.prompts.string;

import org.codeforall.studio.InputPrompt;

import java.io.*;

public class StringInputPrompt implements InputPrompt<String> {

    private char[] data = new char[20];
    private String actualData="";
    private String message;
    int charRead;

    public StringInputPrompt(String message)  {
        this.message = message;
    }

    @Override
    public void show(PrintStream output) throws IOException {
        output.println(message);
    }

    @Override
    public void error(PrintStream output) {
        output.println("Invalid String Input");

    }

    @Override
    public String getUserInput() {

        for (int i = 0; i <charRead; i++) {
            actualData = actualData + data[i];
        }

            return new String(actualData);

    }

    @Override
    public boolean hasValidInput(BufferedReader input) throws IOException {

        charRead = input.read(data);

        if (charRead != -1)  {
            return true;
        }  // DOESNT WORK WHEN I CLICK ONLY ENTER INTO THE CONSOLE, I DONT KNOW WHY

        throw new UnsupportedOperationException();

    }
}
