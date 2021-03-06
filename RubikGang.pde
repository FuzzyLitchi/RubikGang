Cube cube = new Cube();

void setup() {
    // 2D
    // size(500, 500);

    // 3D
    size(500, 500, P3D);
    hint(ENABLE_DEPTH_SORT);
}

boolean showHelp = true;
boolean do3D = true;

void draw() {
    // Render help screen
    if (showHelp) {
        background(0);
        textSize(19);
        fill(255);

        text("To rotate the faces of the cube press one of\nthe following keys.\nU => Up\nD => Down\nF => Front\nB => Back\nL => Left\nR => Right\nHold shift to rotate counter clockwise instead\nof clockwise.\n\nPress Shift + S to scramble the cube.\nPress J to switch between 3D and 2D.\nPress Enter to exit the help menu\nand H to return at a later time.", 20, 40);

        // Don't render the rest
        return;
    }

    background(64);

    if (!do3D) {
        cube.draw(this);
        return;
    }

    // Fix z-axis to grow as depth
    scale(1, 1, -1);

    // cube.draw(this);

    pushMatrix();
    // Move to middle of screen
    translate(
        width/2,
        height/2,
        0
    );

    // Rotate coordinate system according to mouse.
    rotateY(
        -2*PI*(((float) mouseX/width)-0.5)
    );
    rotateX(
        PI*(((float) mouseY/height)-0.5)
    );

    // Move to top left corner of the cube so it is centered on the screen when rendered.
    translate(
        -Cube.faceSize/2,
        -Cube.faceSize/2,
        -Cube.faceSize/2
    );

    cube.draw3D(this);
    popMatrix();
}

void keyPressed() {
    if (showHelp) {
        // Enter to exit help
        if (key == '\n') {
            showHelp = false;
        }

        // Don't process other keypresses in help menu
        return;
    }

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
        case 'h':
        case 'H':
            // Show help
            showHelp = true;
            return;
        case 'j':
        case 'J':
            do3D = !do3D;
            return;
        default:
            return;
    }

    cube.doMove(move);
}