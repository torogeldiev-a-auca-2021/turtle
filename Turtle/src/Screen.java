public class Screen {
    public char[][] data; //field, data member
    private int width;
    private int height;

    //constructor
    public Screen(int aHeight, int aWidth) {
        if (aHeight <= 0 || aWidth <= 0) {
            throw new RuntimeException("Screen constructor: incorrect size " + aHeight + "x" + aWidth);
        }
        width = aWidth;
        height = aHeight;
        data = new char[width][height];
        for (int row = 0; row < height; ++row) {
            for (int col = 0; col < width; ++col) {
                data[row][col] = '.';
            }
        }
    }

    //regular method
    public void print() {
        for (int row = 0; row < height; ++row) {
            for (int col = 0; col < width; ++col) {
                System.out.print(data[row][col]);
            }
            System.out.println();
        }
    }

    public void drawAt(int row, int col) {
        if (row < 0 || height <= row || col < 0 || width <= col) {
            throw new RuntimeException("Screen.drawAt: incorrect coordinates " + row + "");
        }
        data[row][col] = '*';
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}