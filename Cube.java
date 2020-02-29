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
        
        // Bottom and yellow face
        for (Coordinates coords : Face.coordsFromSide(Side.B)) {
            Cubie cubie = getCubieFromCoordinate(coords);
            cubie.B = Colour.YELLOW;
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

    final static int size = 32;
    // 2d
    void drawFace(PApplet processing, Side side) {
        for (Coordinates coords : Face.coordsFromSide(side)) {
            Cubie cubie = getCubieFromCoordinate(coords);
            
            RGB rgb = cubie.getColourOfSide(side).intoRGB();
            processing.fill(rgb.red, rgb.green, rgb.blue);
            processing.rect(coords.x*size, coords.y*size, size, size);
        }
    }
}
