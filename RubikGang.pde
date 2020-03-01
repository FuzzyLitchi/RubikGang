Cube cube = new Cube();

void setup() {
    // 2D
    // size(500, 500);

    // 3D
    size(500, 500, P3D);
    hint(ENABLE_DEPTH_SORT);
}

void draw() {
    background(64);
    // Fix z-axis to grow as depth
    scale(1, 1, -1);

    // cube.draw(this);
    cube.draw3D(this);
}

void keyPressed() {
    Move move;

    // Match keys to moves. Shift + key is prime moves.
    switch (key) {
        case 'u':
            move = Move.U;
            break;
        case 'U':
            move = Move.Up;
            break;
        case 'd':
            move = Move.D;
            break;
        case 'D':
            move = Move.Dp;
            break;
        case 'l':
            move = Move.L;
            break;
        case 'L':
            move = Move.Lp;
            break;
        case 'r':
            move = Move.R;
            break;
        case 'R':
            move = Move.Rp;
            break;
        case 'f':
            move = Move.F;
            break;
        case 'F':
            move = Move.Fp;
            break;
        case 'b':
            move = Move.B;
            break;
        case 'B':
            move = Move.Bp;
            break;
        case 'S':
            // Scramble
            for (int i = 0; i < 50; i++) {
                cube.doMove(Move.fromInt((int) random(0, 12)));
            }
            return;
        default:
            return;
    }

    cube.doMove(move);
}