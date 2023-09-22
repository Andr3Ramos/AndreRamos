package org.codeforall.studio.prompts.precisionDouble;

import org.codeforall.studio.InputScanner;

import java.io.BufferedReader;
import java.io.PrintStream;

public class DoubleInputScanner implements InputScanner<Double> {

    @Override
    public void show(PrintStream output) {

    }

    @Override
    public void error(PrintStream output) {

    }

    @Override
    public Double getUserInput() {

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasValidInput(BufferedReader input) {

        throw new UnsupportedOperationException();
    }
}
