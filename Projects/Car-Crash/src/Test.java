import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Line;

public class Test {

    public static void main(String[] args) {

        Ellipse ellipse = new Ellipse(10, 10, 500, 500);
        ellipse.setColor(Color.ORANGE);
        ellipse.fill();

        Ellipse eye1 = new Ellipse(120, 170, 70, 70);
        eye1.setColor(Color.BLACK);
        eye1.fill();

        Ellipse eye2 = new Ellipse(320, 170, 70, 70);
        eye2.setColor(Color.BLACK);
        eye2.fill();

        Line line = new Line(150, 300, 300, 0);
        line.setColor(Color.RED);
        line.draw();
    }
}
