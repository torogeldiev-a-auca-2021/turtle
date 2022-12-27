import java.util.Scanner;

public class Main {
    static final int SCREEN_WIDTH = 20;
    static final int SCREEN_HEIGHT = 20;

    Scanner inp = new Scanner(System.in);
    int numberOfLine = 0;
    Screen screen;
    Turtle turtle;

    public static void main(String[] args) {
        try{
            Main app = new Main();
            app.runApplication();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    Main() {
        screen = new Screen(SCREEN_HEIGHT, SCREEN_WIDTH);
        turtle = new Turtle(screen, 0, 0, Turtle.RIGHT, false);
    }

    private void runApplication() {
        try {
            run();
        } catch (RuntimeException e) {
            System.out.println("Problem in line: " + numberOfLine + ":");
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        UserCommand userCommand = new UserCommand(inp.nextLine());
        while (!userCommand.getName().equals("Exit")) {
            switch (userCommand.getName()) {
                case "Print":
                    screen.print();
                    break;
                case "PenUp":
                    turtle.penUp();
                    break;
                case "PenDown":
                    turtle.penDown();
                    break;
                case "TurnLeft":
                    turtle.turnLeft();
                    break;
                case "TurnRight":
                    turtle.turnRight();
                    break;
                case "Move":
                    turtle.move(userCommand.getNumberOfSteps());
                    break;
            }
            userCommand = new UserCommand(inp.nextLine());
        }
    }
}