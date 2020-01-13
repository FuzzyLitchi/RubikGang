import processing.core.PApplet;

import java.util.Arrays;

class Face {
    Colour[] faces;
    Colour middle;

    Face(Colour colour) {
        middle = colour;

        faces = new Colour[8];
        Arrays.fill(faces, colour);
    }

    // Size in pixels of the individual pieces
    final static int size = 32;

    static void drawFace(Colour face, int x, int y, PApplet processing) {
        RGB rgb = face.intoRGB();
        processing.fill(rgb.red, rgb.green, rgb.blue);
        processing.rect(x, y, size, size);
    }

    void draw(float x, float y, PApplet processing) {
        processing.pushMatrix();
        processing.translate(x, y);

        // middle piece
        drawFace(middle, size, size, processing);

        // Render in a clockwise "circle" starting from the top left corner
        drawFace(faces[0], 0, 0, processing);
        drawFace(faces[1], size, 0, processing);
        drawFace(faces[2], 2*size, 0, processing);
        drawFace(faces[3], 2*size, size, processing);
        drawFace(faces[4], 2*size, 2*size, processing);
        drawFace(faces[5], size, 2*size, processing);
        drawFace(faces[6], 0, 2*size, processing);
        drawFace(faces[7], 0, size, processing);

        processing.popMatrix();
    }
}
