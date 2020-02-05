import processing.core.PApplet;
import processing.core.PVector;

class Cube {
    Face[] faces;

    Cube() {
        faces = new Face[] {
            new Face(Colour.WHITE),  // Up
            new Face(Colour.YELLOW), // Down
            new Face(Colour.GREEN),  // Left
            new Face(Colour.BLUE),   // Right
            new Face(Colour.RED),    // Front
            new Face(Colour.ORANGE), // Back
        };
    }

    final static int size = 3*Face.size;
    void draw(PApplet processing) {
        // Up side
        faces[0].draw(size, 0, processing);
        // Down side
        faces[1].draw(size, 2*size, processing);
        // Left side
        faces[2].draw(0, size, processing);
        // Right side
        faces[3].draw(2*size, size, processing);
        // Front side
        faces[4].draw(size, size, processing);
        // Back side
        faces[5].draw(3*size, size, processing);
    }

    // Recieves center of cube, pos, and two rotation informations.
    void draw3d(PVector pos, float longtitude, float latitude, PApplet processing) {
        processing.pushMatrix();
        processing.translate(pos.x, pos.y, pos.z);
        processing.rotateY(longtitude);
        processing.rotateX(latitude);

        // Up side
        faces[0].draw3d(
            new PVector(-size/2, -size/2, -size/2),
            new PVector(Face.size, 0, 0),
            new PVector(0, 0, Face.size),
            processing
        );
        // Down side
        faces[1].draw3d(
            new PVector(-size/2, size/2, size/2),
            new PVector(Face.size, 0, 0),
            new PVector(0, 0, -Face.size),
            processing
        );
        // Left side
        faces[2].draw3d(
            new PVector(-size/2, -size/2, -size/2),
            new PVector(0, 0, Face.size),
            new PVector(0, Face.size, 0),
            processing
        );
        // Right side
        faces[3].draw3d(
            new PVector(size/2, -size/2, size/2),
            new PVector(0, Face.size, 0),
            new PVector(0, 0, -Face.size),
            processing
        );
        // Front side
        faces[4].draw3d(
            new PVector(-size/2, -size/2, size/2),
            new PVector(Face.size, 0, 0),
            new PVector(0, Face.size, 0),
            processing
        );
        // Back side
        faces[5].draw3d(
            new PVector(size/2, -size/2, -size/2),
            new PVector(-Face.size, 0, 0),
            new PVector(0, Face.size, 0),
            processing
        );
        processing.popMatrix();
    }
}
