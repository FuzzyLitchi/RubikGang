import processing.core.PApplet;

public class Cube {
    Face[] faces;

    Cube() {
        faces = new Face[] {
                new Face(Face.Colour.WHITE),
                new Face(Face.Colour.YELLOW),
                new Face(Face.Colour.GREEN),
                new Face(Face.Colour.BLUE),
                new Face(Face.Colour.RED),
                new Face(Face.Colour.ORANGE),
        };
    }

    void draw(PApplet processing) {
        processing.beginShape(processing.POINTS);
        processing.vertex(0, 0,0);
        processing.vertex(100,0,0);
        processing.vertex(100,100,0);
        processing.vertex(0,100,0);
        processing.endShape(processing.CLOSE);
    }
}
