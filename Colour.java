enum Colour {
    RED,
    GREEN,
    BLUE,
    YELLOW,
    WHITE,
    ORANGE;

    // Get colour as rgb value. Used for rendering.
    public RGB intoRGB() {
        switch (this) {
            case RED: return new RGB(255, 0, 0);
            case GREEN: return new RGB(0, 255, 0);
            case BLUE: return new RGB(0, 0, 255);
            case YELLOW: return new RGB(255, 255, 0);
            case WHITE: return new RGB(255, 255, 255);
            case ORANGE: return new RGB(255, 127, 0);
        }

        return new RGB(255, 0, 255);
    }

    // Used for debug printing
    public char intoChar() {
        switch (this) {
            case RED: return 'R';
            case GREEN: return 'G';
            case BLUE: return 'B';
            case YELLOW: return 'Y';
            case WHITE: return 'W';
            case ORANGE: return 'O';
        }

        return '!';
    }
}

class RGB {
    public int red;
    public int green;
    public int blue;

    RGB(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
}