import org.codeforall.studio.Prompt;
import org.codeforall.studio.prompts.integer.IntegerRangeInputPrompt;
import org.codeforall.studio.prompts.precisionDouble.DoubleRangeInputPrompt;
import org.codeforall.studio.prompts.string.StringInputPrompt;

import java.io.IOException;

public class QuickProgram implements Program {


    Prompt prompt;

    String clothes;

    Double timeChosen;

    int tempRange;
    String[] clothesArray;


    public QuickProgram(Prompt prompt) {
        this.prompt = prompt;
    }


    @Override
    public void checkClothes() throws IOException {

        StringInputPrompt stringInputPrompt = new StringInputPrompt("Quick program chosen check the clothing label before wash, write what you want to wash separated by white spaces.");
        clothes = prompt.getUserInput(stringInputPrompt);
        clothesArray = clothes.split("\\s+");

    }

    @Override
    public void checkTime() throws IOException {
        DoubleRangeInputPrompt testDoubleRange = new DoubleRangeInputPrompt("Choose the amount of time between 0.20 and 2.0 hours.", 0.2, 2.0);
        timeChosen = prompt.getUserInput(testDoubleRange);


    }

    @Override
    public void checkTemperature() throws IOException {

        IntegerRangeInputPrompt testIntRange = new IntegerRangeInputPrompt("Write the temperature you want pick between 10 and 30 degrees.", 10, 30);
        tempRange = prompt.getUserInput(testIntRange);

    }

    @Override
    public void showOptions() {



        System.out.println("The washing machines is washing :");

        for (String item : clothesArray) {
            System.out.println(item);
        }

        System.out.println("The washing machine will take "+ timeChosen + " hours."+ "\n" +
                           "The washing machine will wash at " + tempRange + " degrees." );



    }


}