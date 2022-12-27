public class Turtle {

    public static final int UP = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;

    private Screen screen;
    private int row;
    private int col;
    private int dir;
    private boolean isPenDown;


    public Turtle(Screen aScreen,int aRow, int aCol,int aDir, boolean penDown) {
        screen = aScreen;
        row = aRow;
        col = aCol;
        dir = aDir;
        isPenDown = penDown;

        if (isOffScreen()) {
            throw new RuntimeException("Turtle: incorrect position " + row + ", " + col);
        }
        if(dir!= UP && dir != DOWN && dir != LEFT && dir != RIGHT) {
            throw new RuntimeException("Turtle: incorrect direction (0..3): " + dir);
        }
    }

    public void turnLeft() {
        dir = dir == UP ? LEFT : dir - 1;
    }

    public void turnRight() {
        dir = dir == LEFT ? UP : dir + 1;
    }

    public void move(int numOfSteps) {
        for (int i = 0; i < numOfSteps; ++i) {
            switch (dir) {
                case UP:
                    --row;
                    break;
                case RIGHT:
                    ++col;
                    break;
                case DOWN:
                    ++row;
                    break;
                case LEFT:
                    --col;
                    break;
            }
            if (isOffScreen()) {
                throw new RuntimeException("Turtle is off the screen: " + row + ", " + col);
            }
            if (isPenDown) {
                screen.drawAt(row, col);
            }
        }
    }

    public void penUp(){
        isPenDown = false;
    }

    public void penDown(){
        isPenDown = true;
        screen.drawAt(row, col);
    }
    private boolean isOffScreen() {
        return row < 0 || screen.getHeight() <= row || col < 0 || screen.getWidth() <= col;
    }

}