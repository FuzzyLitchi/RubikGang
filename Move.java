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

    static Move fromInt(int n) {
        switch (n) {
            case 0: return Move.U;
            case 1: return Move.Up;
            case 2: return Move.D;
            case 3: return Move.Dp;
            case 4: return Move.L;
            case 5: return Move.Lp;
            case 6: return Move.R;
            case 7: return Move.Rp;
            case 8: return Move.F;
            case 9: return Move.Fp;
            case 10: return Move.B;
            case 11: return Move.Bp;
        }

        throw new IllegalArgumentException("Integer has to be between 0 and 11 (inclusive)");
    }

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
                return new Coordinates[]{
                    new Coordinates(2, 2, 1),
                    new Coordinates(1, 2, 2),
                    new Coordinates(0, 2, 1),
                    new Coordinates(1, 2, 0)
                };
            case L:
            case Lp:
                return new Coordinates[]{
                    new Coordinates(0, 0, 1),
                    new Coordinates(0, 1, 0),
                    new Coordinates(0, 2, 1),
                    new Coordinates(0, 1, 2)
                };
            case R:
            case Rp:
                return new Coordinates[]{
                    new Coordinates(2, 1, 2),
                    new Coordinates(2, 2, 1),
                    new Coordinates(2, 1, 0),
                    new Coordinates(2, 0, 1)
                };
            case F:
            case Fp:
                return new Coordinates[]{
                    new Coordinates(0, 1, 0),
                    new Coordinates(1, 0, 0),
                    new Coordinates(2, 1, 0),
                    new Coordinates(1, 2, 0)
                };
            case B:
            case Bp:
                return new Coordinates[]{
                    new Coordinates(1, 2, 2),
                    new Coordinates(2, 1, 2),
                    new Coordinates(1, 0, 2),
                    new Coordinates(0, 1, 2)
                };
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
                return new Coordinates[]{
                    new Coordinates(2, 2, 0),
                    new Coordinates(2, 2, 2),
                    new Coordinates(0, 2, 2),
                    new Coordinates(0, 2, 0)
                };
            case L:
            case Lp:
                return new Coordinates[]{
                    new Coordinates(0, 0, 0),
                    new Coordinates(0, 2, 0),
                    new Coordinates(0, 2, 2),
                    new Coordinates(0, 0, 2)
                };
            case R:
            case Rp:
                return new Coordinates[]{
                    new Coordinates(2, 0, 2),
                    new Coordinates(2, 2, 2),
                    new Coordinates(2, 2, 0),
                    new Coordinates(2, 0, 0)
                };
            case F:
            case Fp:
                return new Coordinates[]{
                    new Coordinates(0, 0, 0),
                    new Coordinates(2, 0, 0),
                    new Coordinates(2, 2, 0),
                    new Coordinates(0, 2, 0)
                };
            case B:
            case Bp:
                return new Coordinates[]{
                    new Coordinates(0, 2, 2),
                    new Coordinates(2, 2, 2),
                    new Coordinates(2, 0, 2),
                    new Coordinates(0, 0, 2)
                };
        }

        throw new IllegalArgumentException("Move has to be one of UDLRFB.");
    }
}