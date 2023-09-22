package org.codeforall.studio.prompts.precisionDouble;

import org.codeforall.studio.exceptions.IntOutOfRangeException;

import java.io.BufferedReader;
import java.io.IOException;

public class DoubleRangeInputPrompt extends DoubleInputPrompt {

    private double begin;
    private double end;
    private String actualData="";
    private Double doubData;
    private int charRead;
    private char[] data = new char[20];

    public DoubleRangeInputPrompt(String message, double begin, double end)  {

        super(message);
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Double getUserInput() {

        return doubData;

       // throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasValidInput(BufferedReader input) throws IOException {

        charRead = input.read(data);

        for (int i = 0; i <charRead-1; i++) {  // needs to be charRead.length-1 because it reads the "OK PRESS" as a character (the last one...)
            actualData = actualData + data[i];
        }

        try {
            doubData = Double.parseDouble(actualData);  // check if input is an Double

            if ( doubData >= begin && doubData <= end )  {  // check if input is within double range
                return true;
            }
            else {
                throw new IntOutOfRangeException();
            }

        }  catch (NumberFormatException ex)  {

            System.out.println("Input is not a Double.");
            actualData ="";
            return false;

        }  catch (IntOutOfRangeException ex) {

            System.out.println("Double out of possible range.");
            actualData ="";
            doubData= (double) 0;
            return false;

        }

       // throw new UnsupportedOperationException();
    }
}
