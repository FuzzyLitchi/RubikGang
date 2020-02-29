Cube cube = new Cube();

void setup() {
    // 2D
    size(500, 500);

    // 3D
    // size(500, 500, P3D);
    // hint(ENABLE_DEPTH_SORT);
}

int i = 0;
void draw() {
    if (frameCount%30 == 0) {
        Move move;
        if (i < 12) {
            move = Move.fromInt(i);
        } else {
            move = Move.fromInt((int) random(0, 12));
        }

        i++;
        print(move);
        cube.doMove(move);
        print(" ");
        println(cube.isSolved());
    }

    background(64);
    cube.draw(this);
}
