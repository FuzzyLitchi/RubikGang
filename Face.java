import processing.core.PApplet;
import processing.core.PVector;

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

    // 2D rendering functions
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

    // 3D rendering functions
    void draw3d(PVector pos, PVector r1, PVector r2, PApplet processing) {
        processing.pushMatrix();
        processing.translate(pos.x, pos.y, pos.z);

        // Render middle face
        drawFace3d(middle, r1, r2, 1, 1, processing);
        
        // Render in a clockwise "circle" starting from the top left corner
        drawFace3d(faces[0], r1, r2, 0, 0, processing);
        drawFace3d(faces[1], r1, r2, 1, 0, processing);
        drawFace3d(faces[2], r1, r2, 2, 0, processing);
        drawFace3d(faces[3], r1, r2, 2, 1, processing);
        drawFace3d(faces[4], r1, r2, 2, 2, processing);
        drawFace3d(faces[5], r1, r2, 1, 2, processing);
        drawFace3d(faces[6], r1, r2, 0, 2, processing);
        drawFace3d(faces[7], r1, r2, 0, 1, processing);

        processing.popMatrix();
    }

    void drawFace3d(Colour face, PVector r1, PVector r2, int s1, int s2, PApplet processing) {
        RGB rgb = face.intoRGB();
        processing.fill(rgb.red, rgb.green, rgb.blue);
        processing.beginShape();

        processing.vertex(
            r1.x*s1+r2.x*s2,
            r1.y*s1+r2.y*s2,
            r1.z*s1+r2.z*s2
        );
        processing.vertex(
            r1.x*(s1+1)+r2.x*s2,
            r1.y*(s1+1)+r2.y*s2,
            r1.z*(s1+1)+r2.z*s2
        );
        processing.vertex(
            r1.x*(s1+1)+r2.x*(s2+1),
            r1.y*(s1+1)+r2.y*(s2+1),
            r1.z*(s1+1)+r2.z*(s2+1)
        );
        processing.vertex(
            r1.x*s1+r2.x*(s2+1),
            r1.y*s1+r2.y*(s2+1),
            r1.z*s1+r2.z*(s2+1)
        );

        processing.endShape(processing.CLOSE);
    }
}
