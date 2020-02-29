Cube cube = new Cube();

void setup() {
    // 2D
    size(500, 500);

    // 3D
    // size(500, 500, P3D);
    // hint(ENABLE_DEPTH_SORT);
    
}

void draw() {
    background(64);
    cube.drawFace(this, Side.F);
}
