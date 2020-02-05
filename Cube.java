import processing.core.PApplet;

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
}
