package org.codeforall.studio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public interface InputPrompt<T> {

    void show(PrintStream output) throws IOException;
    void error(PrintStream output);

    T getUserInput();
    boolean hasValidInput(BufferedReader input) throws IOException;


}
