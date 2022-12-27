import java.util.Scanner;

public class UserCommand {
    String name;
    private int numberOfSteps;

    public UserCommand(String line) {
        line = line.trim();

        switch (line) {
            case "Print":
            case "PenDown":
            case "PenUp":
            case "TurnLeft":
            case "TurnRight":
            case "Exit":
                name = line;
                numberOfSteps = 0;
                return;
        }

        Scanner lineInp = new Scanner(line);
        String isko = lineInp.next();
        if (!isko.equals("Move")) {
            throw new RuntimeException("Incorrect command: '" + line + "'");
        }
        if (!lineInp.hasNextInt()) {
            throw new RuntimeException("Incorrect number of steps in command: '" + line + "'");
        }

        int numberOfSteps = lineInp.nextInt();
        if (numberOfSteps < 0) {
            throw new RuntimeException("Negative number of steps in command: '" + line + "'");
        }
        if(lineInp.hasNext()) {
            throw new RuntimeException("Too many arguments in command: '" + line + "'");
        }
        name = isko;
        this.numberOfSteps = numberOfSteps;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }
}