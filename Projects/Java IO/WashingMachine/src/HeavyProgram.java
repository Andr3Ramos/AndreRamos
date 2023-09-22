import org.codeforall.studio.Prompt;
import org.codeforall.studio.prompts.integer.IntegerRangeInputPrompt;
import org.codeforall.studio.prompts.precisionDouble.DoubleRangeInputPrompt;
import org.codeforall.studio.prompts.string.StringInputPrompt;

import java.io.IOException;

public class HeavyProgram implements Program {

    Prompt prompt;

    String clothes;

    Double timeChosen;

    int tempRange;
    String[] clothesArray;


    public HeavyProgram(Prompt prompt) {
        this.prompt = prompt;
    }


    @Override
    public void checkClothes() throws IOException {

        StringInputPrompt stringInputPrompt = new StringInputPrompt("Heavy program chosen check the clothing label before wash, write what you want to wash separated by white spaces.");
        clothes = prompt.getUserInput(stringInputPrompt);
        clothesArray = clothes.split("\\s+");

    }

    @Override
    public void checkTime() throws IOException {
        DoubleRangeInputPrompt testDoubleRange = new DoubleRangeInputPrompt("Choose the amount of time between 3.0 and 6.0 hours.", 3.0, 6.0);
        timeChosen = prompt.getUserInput(testDoubleRange);


    }

    @Override
    public void checkTemperature() throws IOException {

        IntegerRangeInputPrompt testIntRange = new IntegerRangeInputPrompt("Write the temperature you want pick between 50 and 80 degrees.", 50, 80);
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
