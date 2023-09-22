package org.codeforall.studio;

import java.io.*;

public class Prompt {

    private BufferedReader input;
    private PrintStream output;

    public Prompt(InputStream input, PrintStream output) {

        InputStreamReader in = new InputStreamReader(input);  // wrapps an inputstream in a inputstreamreader

        this.input = new BufferedReader(in);  // wrapps an inputstreamreader in a bufferedreader
        this.output = output;

       //throw new UnsupportedOperationException();
    }

    public <T> T getUserInput(InputPrompt<T> prompt) throws IOException {

        try {

            prompt.show(output);  // Ask the user something

            if (prompt.hasValidInput(input)) {  // check if user's input is valid
                return prompt.getUserInput();  // if yes return user's input
            } else {
                prompt.error(output);  // otherwise return error and:
                return getUserInput(prompt);  // ask user again
            }

        } catch (UnsupportedOperationException ex) {
            ex.getMessage();
        }
        return null;
    }
}
