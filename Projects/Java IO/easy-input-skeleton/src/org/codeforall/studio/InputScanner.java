package org.codeforall.studio;

import java.io.BufferedReader;
import java.io.PrintStream;

public interface InputScanner<T> {

    void show(PrintStream output);
    void error(PrintStream output);

    T getUserInput();
    boolean hasValidInput(BufferedReader input);


}
