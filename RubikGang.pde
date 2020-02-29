Cube cube = new Cube();

void setup() {
    // 2D
    size(500, 500);

    // 3D
    // size(500, 500, P3D);
    // hint(ENABLE_DEPTH_SORT);
}

void draw() {
    if (frameCount == 60) {
        cube.doMove(Move.U);
    }

    if (frameCount == 120) {
        cube.doMove(Move.Up);
    }

    background(64);
    cube.draw(this);
}
