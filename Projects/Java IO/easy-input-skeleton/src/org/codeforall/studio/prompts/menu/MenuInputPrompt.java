package org.codeforall.studio.prompts.menu;

import org.codeforall.studio.prompts.integer.IntegerRangeInputPrompt;

import java.awt.*;
import java.io.PrintStream;

public class MenuInputPrompt extends IntegerRangeInputPrompt {

    private String[] options;
    private String message;

    private String menu;

    public MenuInputPrompt(String message, int begin, int end, String[] options) {
        super(message, begin, end);
        this.message = message;
        this.options = options;
    }

    @Override
    public void show(PrintStream output) {
        output.println(buildMenu(message, options));

    }
    private String buildMenu(String message, String[] options) {

        menu = (message + "\n");

        for (int i = 1; i <= options.length; i++)  {
            menu = menu + i + ": " + options[i-1] + "\n";
        }

        return menu;

        //throw new UnsupportedOperationException();
    }
}
