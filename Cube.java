import java.util.*;
import processing.core.PApplet;

class Cube {
    // 3x3x3 cubies
    private Cubie[] cubies = new Cubie[27];

    // Helper functions for handing coordinates.
    private Cubie getCubieFromCoordinates(Coordinates c) {
        return cubies[c.x+c.y*3+c.z*9];
    }

    private void setCubieFromCoordinates(Coordinates c, Cubie cubie) {
        cubies[c.x+c.y*3+c.z*9] = cubie;
    }

    // This constructor creates a standard solved rubiks cube.
    Cube() {
        // We create a cubie for every part of the cube.
        for (int i = 0; i < 27; i++) {
            cubies[i] = new Cubie();
        }

        // Upper and white face
        for (Coordinates coords : Face.coordsFromSide(Side.U)) {
            Cubie cubie = getCubieFromCoordinates(coords);
            cubie.U = Colour.WHITE;
        }
        
        // Down and yellow face
        for (Coordinates coords : Face.coordsFromSide(Side.D)) {
            Cubie cubie = getCubieFromCoordinates(coords);
            cubie.D = Colour.YELLOW;
        }

        // Left and green face
        for (Coordinates coords : Face.coordsFromSide(Side.L)) {
            Cubie cubie = getCubieFromCoordinates(coords);
            cubie.L = Colour.GREEN;
        }

        // Right and blue face
        for (Coordinates coords : Face.coordsFromSide(Side.R)) {
            Cubie cubie = getCubieFromCoordinates(coords);
            cubie.R = Colour.BLUE;
        }

        // Front and red face
        for (Coordinates coords : Face.coordsFromSide(Side.F)) {
            Cubie cubie = getCubieFromCoordinates(coords);
            cubie.F = Colour.RED;
        }

        // Back and orange face
        for (Coordinates coords : Face.coordsFromSide(Side.B)) {
            Cubie cubie = getCubieFromCoordinates(coords);
            cubie.B = Colour.ORANGE;
        }
    }

    public boolean isSolved() {
        return this.equals(new Cube());
    }

    public boolean equals(Cube other) {
        for (int i = 0; i < 27; i++) {
            if (!this.cubies[i].equals(other.cubies[i])) {
                return false;
            }
        }

        return true;
    }

    // Applies a given move to the Rubik's Cube.
    public void doMove(Move move) {
        Coordinates[] corners = move.corners();
        Coordinates[] edges = move.edges();

        // Update orientation of cubies
        for (Coordinates coord : corners) {
            getCubieFromCoordinates(coord).rotate(move);
        }
        for (Coordinates coord : edges) {
            getCubieFromCoordinates(coord).rotate(move);
        }
        
        // Update position of cubies
        // Starting with corners
        Coordinates[] from = corners;
        Coordinates[] to = corners.clone();
        Collections.rotate(Arrays.asList(from), move.isPrime() ? -1 : 1);
        

        Cubie[] cubies = new Cubie[4];
        for (int i = 0; i < 4; i++) {
            cubies[i] = getCubieFromCoordinates(from[i]);
        }

        for (int i = 0; i < 4; i++) {
            setCubieFromCoordinates(to[i], cubies[i]);
        }

        // Then with edges
        from = edges;
        to = edges.clone();
        Collections.rotate(Arrays.asList(from), move.isPrime() ? -1 : 1);
        

        cubies = new Cubie[4];
        for (int i = 0; i < 4; i++) {
            cubies[i] = getCubieFromCoordinates(from[i]);
        }

        for (int i = 0; i < 4; i++) {
            setCubieFromCoordinates(to[i], cubies[i]);
        }
    }

    // 2d rendering
    final static int cubieSize = 32;
    final static int faceSize = 3*cubieSize;
    public void draw(PApplet processing) {
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
    private void drawFace(PApplet processing, Side side, int dx, int dy) {
        for (Coordinates coords : Face.coordsFromSide(side)) {
            Cubie cubie = getCubieFromCoordinates(coords);

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

            Colour colour = cubie.getColourOfSide(side);

            RGB rgb;
            if (colour == null) {
                // colour being null means that this side of
                // the cubie doesn't exist. This should never happen.
                rgb = new RGB(255, 0, 255);
            } else {
                rgb = colour.intoRGB();
            }
            processing.fill(rgb.red, rgb.green, rgb.blue);
            processing.rect(x+dx, y+dy, cubieSize, cubieSize);
        }
    }

    // 3D rendering
    public void draw3D(PApplet processing) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    Coordinates coords = new Coordinates(x, y, z);

                    Cubie cubie = getCubieFromCoordinates(coords);
                    cubie.draw3D(processing, coords);
                }
            }
        }
    }
}
