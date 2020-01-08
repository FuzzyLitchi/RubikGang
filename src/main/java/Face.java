import java.util.Arrays;

public class Face {
    Colour[] faces;
    Colour middle;

    enum Colour {
        RED,
        GREEN,
        BLUE,
        YELLOW,
        WHITE,
        ORANGE,
    }

    public Face(Colour colour) {
        middle = colour;

        faces = new Colour[8];
        Arrays.fill(faces, colour);
    }
}
