package org.codeforall.studio.prompts.integer;

import org.codeforall.studio.exceptions.IntOutOfRangeException;

import java.io.BufferedReader;
import java.io.IOException;

public class IntegerRangeInputPrompt extends IntegerInputPrompt {

    private int charRead;

    private char[] data = new char[20];

    private String message;
    private String actualData="";
    private int begin;
    private int end;
    private int intData;

    public IntegerRangeInputPrompt(String message, int begin, int end)  {

        super(message);
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer getUserInput() {

        return intData;

        //throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasValidInput(BufferedReader input) throws IOException {

        charRead = input.read(data);

        for (int i = 0; i <charRead-1; i++) {  // needs to be charRead.length-1 because it reads the "OK PRESS" as a character (the last one...)
            actualData = actualData + data[i];
        }

        try {
            intData = Integer.parseInt(actualData);  // check if input is an Int

            if ( intData >= begin && intData <= end )  {  // check if input is within int range
                return true;
            }
            else {
                throw new IntOutOfRangeException();
            }

        }  catch (NumberFormatException ex)  {

            System.out.println("Input is not an Int.");
            actualData ="";
            return false;

        }  catch (IntOutOfRangeException ex) {

            System.out.println("Int out of possible range.");
            actualData ="";
            intData=0;
            return false;

        }

        //throw new UnsupportedOperationException();
    }
}
