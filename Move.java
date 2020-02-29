// Location of a cubie on the cube. Ranges from (0, 0, 0) to (2, 2, 2)
// (0, 0, 0) is located at the ulf (upper left front corner).
// I chose this coordinate system because processing's coordinate system
// has (0, 0, 0) at the upper left corner of the screen and the z axis
// is depth. Thereby the cube and processing's coordinates have the same
// orientation. 
class Coordinates {
    int x;
    int y;
    int z;

    Coordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

enum Move {
    U, // Up
    D, // Down
    L, // Left
    R, // Right
    F, // Front
    B; // Back

    // Returns the coordinates for the 4 edge cubies that are 
    // affected by this move in clockewise direction.
    Coordinates[] edges() {
        switch (this) {
            case U: return new Coordinates[]{
                new Coordinates(1, 2, 0),
                new Coordinates(0, 2, 1),
                new Coordinates(1, 2, 2),
                new Coordinates(2, 2, 1)
            };
            case D: return null;
            case L: return null;
            case R: return null;
            case F: return null;
            case B: return null;
        }

        throw new IllegalArgumentException("Move has to be one of UDLRFB.");
    }

    // Returns the coordinates for the 4 corner cubies that are
    // affected by this move in clockwise direction.
    Coordinates[] corners() {
        switch (this) {
            case U: return new Coordinates[]{
                new Coordinates(0, 2, 0),
                new Coordinates(0, 2, 2),
                new Coordinates(2, 2, 2),
                new Coordinates(2, 2, 0)
            };
            case D: return null;
            case L: return null;
            case R: return null;
            case F: return null;
            case B: return null;
        }

        throw new IllegalArgumentException("Move has to be one of UDLRFB.");
    }
}