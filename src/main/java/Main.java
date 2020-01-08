import processing.core.PApplet;
import processing.opengl.PGraphics3D;

public class Main extends PApplet {
    Cube cube = new Cube();

    public void settings() {
        size(500, 500);
    }

    public void draw(){
        background(64);
        cube.draw(this);
    }

    public static void main(String[] args) {
        String[] appletArgs = new String[] { "Main" };
        PApplet.main(appletArgs);
    }
}
