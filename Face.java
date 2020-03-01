// Helper function for interacting with the cube by faces
class Face {

    // Returns the coordinates for the cubies of a given side.
    public static Coordinates[] coordsFromSide(Side s) {
        Coordinates[] coords = new Coordinates[9];

        switch (s) {
            case U:
                for (int x = 0; x < 3; x++) {
                    for (int z = 0; z < 3; z++) {
                        coords[3*x+z] = new Coordinates(x, 0, z);
                    }
                }

                return coords;
            case D:
                for (int x = 0; x < 3; x++) {
                    for (int z = 0; z < 3; z++) {
                        coords[3*x+z] = new Coordinates(x, 2, z);
                    }
                }

                return coords;
            case L:
                for (int y = 0; y < 3; y++) {
                    for (int z = 0; z < 3; z++) {
                        coords[3*y+z] = new Coordinates(0, y, z);
                    }
                }

                return coords;
            case R:
                for (int y = 0; y < 3; y++) {
                    for (int z = 0; z < 3; z++) {
                        coords[3*y+z] = new Coordinates(2, y, z);
                    }
                }

                return coords;
            case F:
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        coords[3*x+y] = new Coordinates(x, y, 0);
                    }
                }

                return coords;
            case B:
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        coords[3*x+y] = new Coordinates(x, y, 2);
                    }
                }

                return coords;
        }

        throw new IllegalArgumentException("Not reachable.");
    }
}