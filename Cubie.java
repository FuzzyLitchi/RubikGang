import java.util.*;
import processing.core.PApplet;

class Cubie {
    public Colour U; // Up
    public Colour D; // Down
    public Colour L; // Left
    public Colour R; // Right
    public Colour F; // Front
    public Colour B; // Back

    Cubie() {}

    public boolean equals(Cubie other) {
        return this.U == other.U &&
            this.D == other.D &&
            this.L == other.L &&
            this.R == other.R &&
            this.F == other.F &&
            this.B == other.B;
    }

    // Rotates cubie according to a specified move.
    public void rotate(Move move) {
        switch (move) {
            case U:
                rotateU(1);
                break;
            case Up:
                rotateU(-1);
                break;
            case D:
                rotateU(-1);
                break;
            case Dp:
                rotateU(1);
                break;
            case L:
                rotateL(1);
                break;
            case Lp:
                rotateL(-1);
                break;
            case R:
                rotateL(-1);
                break;
            case Rp:
                rotateL(1);
                break;
            case F:
                rotateF(1);
                break;
            case Fp:
                rotateF(-1);
                break;
            case B:
                rotateF(-1);
                break;
            case Bp:
                rotateF(1);
                break;
        }
    }

    // Helper functions to rotate the cubie in the three spacial dimension
    private void rotateF(int n) {
        if (n != -1 && n != 1) {
            throw new IllegalArgumentException("n has to be 1 or -1");
        }

        Colour[] rotated = {U, R, D, L};
        Collections.rotate(Arrays.asList(rotated), n);
        U = rotated[0];
        R = rotated[1];
        D = rotated[2];
        L = rotated[3];
    }

    private void rotateU(int n) {
        if (n != -1 && n != 1) {
            throw new IllegalArgumentException("n has to be 1 or -1");
        }

        Colour[] rotated = {F, L, B, R};
        Collections.rotate(Arrays.asList(rotated), n);
        F = rotated[0];
        L = rotated[1];
        B = rotated[2];
        R = rotated[3];
    }
    
    private void rotateL(int n) {
        if (n != -1 && n != 1) {
            throw new IllegalArgumentException("n has to be 1 or -1");
        }

        Colour[] rotated = {U, F, D, B};
        Collections.rotate(Arrays.asList(rotated), n);
        U = rotated[0];
        F = rotated[1];
        D = rotated[2];
        B = rotated[3];
    }

    // Gets colour of given side. Returns null if side doesn't exist
    public Colour getColourOfSide(Side s) {
        switch (s) {
            case U: return this.U;
            case D: return this.D;
            case L: return this.L;
            case R: return this.R;
            case F: return this.F;
            case B: return this.B;
        }

        throw new IllegalArgumentException("Oof");
    }

    // Debug printing
    public String toString() {
        // Prints cubie as 2d unfolding of a cube
        // U
        //LFRB
        // D
        String string = new String();

        string += ' ';
        string += checkedIntoChar(U);
        string += '\n';

        string += checkedIntoChar(L);
        string += checkedIntoChar(F);
        string += checkedIntoChar(R);
        string += checkedIntoChar(B);
        string += '\n';

        string += ' ';
        string += checkedIntoChar(D);
        
        return string;
    }

    // Helper function for debug printing
    private static char checkedIntoChar(Colour c) {
        if (c == null) {
            return '?';
        } else {
            return c.intoChar();
        }
    }

    public void draw3D(PApplet processing, Coordinates coords) {
        // Attempt to draw each side
        for (Side side : Side.values()) {
            Colour colour = getColourOfSide(side);
            
            if (colour == null) {
                // Side doesn't exist, skip
                continue;
            }

            // Render
            RGB rgb = colour.intoRGB();
            processing.fill(rgb.red, rgb.green, rgb.blue);
            processing.beginShape();

            // Draw a vertex between each point.
            for (Coordinates point : side.asPoints()) {
                processing.vertex(
                    (coords.x+point.x)*Cube.cubieSize,
                    (coords.y+point.y)*Cube.cubieSize,
                    (coords.z+point.z)*Cube.cubieSize
                );
            }

            processing.endShape(processing.CLOSE);
        }
    }
}