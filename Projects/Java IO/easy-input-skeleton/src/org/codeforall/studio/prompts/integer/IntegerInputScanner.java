package org.codeforall.studio.prompts.integer;

import org.codeforall.studio.InputScanner;

import java.io.BufferedReader;
import java.io.PrintStream;

public class IntegerInputScanner implements InputScanner<Integer> {

    @Override
    public void show(PrintStream output) {

    }

    @Override
    public void error(PrintStream output) {

    }

    @Override
    public Integer getUserInput() {

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasValidInput(BufferedReader input) {

        throw new UnsupportedOperationException();
    }
}
