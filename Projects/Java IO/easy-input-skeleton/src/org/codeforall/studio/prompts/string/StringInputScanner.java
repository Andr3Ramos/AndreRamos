package org.codeforall.studio.prompts.string;

import org.codeforall.studio.InputScanner;

import java.io.BufferedReader;
import java.io.PrintStream;

public class StringInputScanner implements InputScanner<String> {

    @Override
    public void show(PrintStream output) {

    }

    @Override
    public void error(PrintStream output) {

    }

    @Override
    public String getUserInput() {

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasValidInput(BufferedReader input) {

        throw new UnsupportedOperationException();
    }
}
