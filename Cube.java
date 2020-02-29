import processing.core.PApplet;
import processing.core.PVector;

class Cube {
    // 3x3x3 cubies
    Cubie[] cubies = new Cubie[27];

    // Helper functions for handing coordinates.
    Cubie getCubieFromCoordinate(Coordinates c) {
        return cubies[c.x+c.y*3+c.z*9];
    }

    // This constructor creates a standard solved rubiks cube.
    Cube() {
        // We create a cubie for every part of the cube.
        for (int i = 0; i < 27; i++) {
            cubies[i] = new Cubie();
        }

        // Upper and white face
        for (Coordinates coords : Face.coordsFromSide(Side.U)) {
            Cubie cubie = getCubieFromCoordinate(coords);
            cubie.U = Colour.WHITE;
        }
        
        // Down and yellow face
        for (Coordinates coords : Face.coordsFromSide(Side.D)) {
            Cubie cubie = getCubieFromCoordinate(coords);
            cubie.D = Colour.YELLOW;
        }

        // Left and green face
        for (Coordinates coords : Face.coordsFromSide(Side.L)) {
            Cubie cubie = getCubieFromCoordinate(coords);
            cubie.L = Colour.GREEN;
        }

        // Right and blue face
        for (Coordinates coords : Face.coordsFromSide(Side.R)) {
            Cubie cubie = getCubieFromCoordinate(coords);
            cubie.R = Colour.BLUE;
        }

        // Front and red face
        for (Coordinates coords : Face.coordsFromSide(Side.F)) {
            Cubie cubie = getCubieFromCoordinate(coords);
            cubie.F = Colour.RED;
        }

        // Back and orange face
        for (Coordinates coords : Face.coordsFromSide(Side.B)) {
            Cubie cubie = getCubieFromCoordinate(coords);
            cubie.B = Colour.ORANGE;
        }
    }

    // 2d rendering
    final static int cubieSize = 32;
    final static int faceSize = 3*cubieSize;
    void draw(PApplet processing) {
        // Up side
        drawFace(processing, Side.U, faceSize, 0);
        // Down side
        drawFace(processing, Side.D, faceSize, 2*faceSize);
        // Left side
        drawFace(processing, Side.L, 0, faceSize);
        // Right side
        drawFace(processing, Side.R, 2*faceSize, faceSize);
        // Front side
        drawFace(processing, Side.F, faceSize, faceSize);
        // Back side
        drawFace(processing, Side.B, 3*faceSize, faceSize);
    }

    // function to draw a single face
    void drawFace(PApplet processing, Side side, int dx, int dy) {
        for (Coordinates coords : Face.coordsFromSide(side)) {
            Cubie cubie = getCubieFromCoordinate(coords);

            // Calculate x and y position on the 2d plane.
            int x = 0;
            int y = 0;
            switch (side) {
                case U:
                    x = coords.x * cubieSize;
                    y = (2-coords.z) * cubieSize;
                    break;
                case D:
                    x = coords.x * cubieSize;
                    y = coords.z * cubieSize;
                    break;
                case L:
                    x = (2-coords.z) * cubieSize;
                    y = coords.y * cubieSize;
                    break;
                case R:
                    x = coords.z * cubieSize;
                    y = coords.y * cubieSize;
                    break;
                case F:
                    x = coords.x * cubieSize;
                    y = coords.y * cubieSize;
                    break;
                case B:
                    x = (2-coords.x) * cubieSize;
                    y = coords.y * cubieSize;
                    break;
            }

            RGB rgb = cubie.getColourOfSide(side).intoRGB();
            processing.fill(rgb.red, rgb.green, rgb.blue);
            processing.rect(x+dx, y+dy, cubieSize, cubieSize);
        }
    }
}
