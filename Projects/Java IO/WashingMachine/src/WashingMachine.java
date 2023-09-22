import org.codeforall.studio.Prompt;
import org.codeforall.studio.prompts.menu.MenuInputPrompt;
import java.io.IOException;

public class WashingMachine {




    public void init() throws IOException {

    Prompt prompt = new Prompt(System.in, System.out);

    String[] options = {"Delicate washing program",
            "Heavy washing program",
            "Quick washing program",
            "Shut Down"
    };
    String menu = "Choose a program:" + "\n";

    MenuInputPrompt testMenu = new MenuInputPrompt(menu, 1, 4, options);

    int option = prompt.getUserInput(testMenu);

    switch (option) {
        case 1:
            DelicateProgram delicateProgram = new DelicateProgram(prompt);
            runProgram(delicateProgram);
            break;
        case 2:
            HeavyProgram heavyProgram = new HeavyProgram(prompt);
            runProgram(heavyProgram);
            break;
        case 3:
            QuickProgram quickProgram = new QuickProgram(prompt);
            runProgram(quickProgram);
            break;
        case 4:
            break;
    }
}

    private void runProgram(Program program) throws IOException {
        program.checkClothes();
        program.checkTime();
        program.checkTemperature();
        program.showOptions();

        System.out.println(); // Add empty line
        System.out.println(); // Add empty line

        init();
    }


}



