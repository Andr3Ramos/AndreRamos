package org.codeforall.studio;

import org.codeforall.studio.prompts.string.StringInputPrompt;

import java.io.IOException;
import org.codeforall.studio.prompts.integer.IntegerInputPrompt;
import org.codeforall.studio.prompts.integer.IntegerRangeInputPrompt;
import org.codeforall.studio.prompts.menu.MenuInputPrompt;
import org.codeforall.studio.prompts.precisionDouble.DoubleInputPrompt;
import org.codeforall.studio.prompts.precisionDouble.DoubleRangeInputPrompt;

public class Test {

    public static void main(String[] args) throws IOException {

        Prompt prompt = new Prompt(System.in, System.out);

        // TESTS INTERACTING WITH THE CONSOLE

        // :::: TEST STRINGINPUT
        StringInputPrompt testString = new StringInputPrompt("StringInput");
        String ola = prompt.getUserInput(testString);
        System.out.println(ola);

        // :::: TEST INTINPUT
        IntegerInputPrompt testInt = new IntegerInputPrompt("IntInput");
        int ola2 = prompt.getUserInput(testInt);
        System.out.println(ola2);


        // :::: TEST INTRANGEINPUT
        IntegerRangeInputPrompt testIntRange = new IntegerRangeInputPrompt("IntRange", 1, 3);
        int ola3 = prompt.getUserInput(testIntRange);
        System.out.println(ola3);

        // :::: TEST MENUINPUT
        String[] opcoes = {"gato","cao","vaca"};
        String menu = "Teste menu";
        MenuInputPrompt testMenu = new MenuInputPrompt(menu, 1, 3, opcoes);
        int ola4 = prompt.getUserInput(testMenu);
        System.out.println(ola4);

        // ::::: TEST DOUBLEINPUT
        DoubleInputPrompt testDoub = new DoubleInputPrompt("DoubleInput");
        double ola5 = prompt.getUserInput(testDoub);
        System.out.println(ola5);

        // :::: TEST DOUBLERANGEINPUT
        DoubleRangeInputPrompt testDoubRange = new DoubleRangeInputPrompt("DoubleRange", 1.0, 5.0);
        double ola6 = prompt.getUserInput(testDoubRange);
        System.out.println(ola6);

    }
}