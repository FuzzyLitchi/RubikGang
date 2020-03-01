enum Side {
    U, // Up
    D, // Down
    L, // Left
    R, // Right
    F, // Front
    B; // Back

    // Gives the 4 corners of each side. Used for 3d rendering.
    public Coordinates[] asPoints() {
        switch(this) {
            case U:
                return new Coordinates[]{
                    new Coordinates(0, 0, 0),
                    new Coordinates(1, 0, 0),
                    new Coordinates(1, 0, 1),
                    new Coordinates(0, 0, 1)
                };
            case D:
                return new Coordinates[]{
                    new Coordinates(0, 1, 0),
                    new Coordinates(1, 1, 0),
                    new Coordinates(1, 1, 1),
                    new Coordinates(0, 1, 1)
                };
            case L:
                return new Coordinates[]{
                    new Coordinates(0, 0, 0),
                    new Coordinates(0, 1, 0),
                    new Coordinates(0, 1, 1),
                    new Coordinates(0, 0, 1)
                };
            case R:
                return new Coordinates[]{
                    new Coordinates(1, 0, 0),
                    new Coordinates(1, 1, 0),
                    new Coordinates(1, 1, 1),
                    new Coordinates(1, 0, 1)
                };
            case F:
                return new Coordinates[]{
                    new Coordinates(0, 0, 0),
                    new Coordinates(1, 0, 0),
                    new Coordinates(1, 1, 0),
                    new Coordinates(0, 1, 0)
                };
            case B:
                return new Coordinates[]{
                    new Coordinates(0, 0, 1),
                    new Coordinates(1, 0, 1),
                    new Coordinates(1, 1, 1),
                    new Coordinates(0, 1, 1)
                };
            default:
                throw new IllegalArgumentException("Unreachable.");
        }
    }
}