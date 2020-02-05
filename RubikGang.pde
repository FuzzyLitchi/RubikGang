Cube cube = new Cube();

PVector pos;

void setup() {
    size(500, 500, P3D);
    hint(ENABLE_DEPTH_SORT);

    pos = new PVector(width/2, height/2, -100);
}

void draw() {
    background(64);
    // cube.draw(this);
    
    cube.draw3d(pos, ((float)frameCount)/100.0, PI/4*sin(((float)frameCount)/100.0), this);
}
