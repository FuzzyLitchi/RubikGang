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

    public String toString() {
        String string = new String();
        string += '(';
        string += x;
        string += ',';
        string += y;
        string += ',';
        string += z;
        string += ')';
        
        return string;
    }
}

enum Move {
    U,  // Up
    Up, // Up prime, usually written as U'
        // Normal moves rotate 90° clockwise
        // prime moves rotate 90° counter clockwise

    D,  // Down
    Dp, // Down prime
    L,  // Left
    Lp, // Left prime
    R,  // Right
    Rp, // Right prime
    F,  // Front
    Fp, // Front prime
    B,  // Back
    Bp; // Back prime

    boolean isPrime() {
        switch (this) {
            case U:
            case D:
            case L:
            case R:
            case F:
            case B:
                return false;
            case Up:
            case Dp:
            case Lp:
            case Rp:
            case Fp:
            case Bp:
                return true;
        }

        throw new IllegalArgumentException("Unreachable");
    }

    // Returns the coordinates for the 4 edge cubies that are 
    // affected by this move in clockewise direction.
    Coordinates[] edges() {
        switch (this) {
            case U:
            case Up:
                return new Coordinates[]{
                    new Coordinates(1, 0, 0),
                    new Coordinates(0, 0, 1),
                    new Coordinates(1, 0, 2),
                    new Coordinates(2, 0, 1)
                };
            case D:
            case Dp:
                return null;
            case L:
            case Lp:
                return null;
            case R:
            case Rp:
                return null;
            case F:
            case Fp:
                return null;
            case B:
            case Bp:
                return null;
        }

        throw new IllegalArgumentException("Move has to be one of UDLRFB.");
    }

    // Returns the coordinates for the 4 corner cubies that are
    // affected by this move in clockwise direction.
    Coordinates[] corners() {
        switch (this) {
            case U:
            case Up:
                return new Coordinates[]{
                    new Coordinates(0, 0, 0),
                    new Coordinates(0, 0, 2),
                    new Coordinates(2, 0, 2),
                    new Coordinates(2, 0, 0)
                };
            case D:
            case Dp:
                return null;
            case L:
            case Lp:
                return null;
            case R:
            case Rp:
                return null;
            case F:
            case Fp:
                return null;
            case B:
            case Bp:
                return null;
        }

        throw new IllegalArgumentException("Move has to be one of UDLRFB.");
    }
}