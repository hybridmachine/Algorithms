// Demonstrating how to use the StdDraw class
import java.awt.Color;
import edu.princeton.cs.algs4.*;
import data_abstraction.*;

public class StdDrawExample {
    public static void main(String[] args) {
        // Set the canvas size (in pixels)
        StdDraw.setCanvasSize(600, 600);

        // Set the scale of the coordinate system (x and y from 0 to 10)
        StdDraw.setScale(0, 10);

        // Draw a blue border around the canvas
        StdDraw.setPenColor(Color.BLUE);
        StdDraw.setPenRadius(0.01);
        StdDraw.square(5.0, 5.0, 5.0);

        // Draw a filled red circle in the center
        StdDraw.setPenColor(Color.RED);
        StdDraw.filledCircle(5.0, 5.0, 2.0);

        // Draw a green triangle using a polygon
        StdDraw.setPenColor(Color.GREEN);
        double[] xPoints = { 1.0, 5.0, 9.0 };
        double[] yPoints = { 1.0, 8.0, 1.0 };
        StdDraw.filledPolygon(xPoints, yPoints);

        // Display text in black
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(5.0, 0.5, "StdDraw Example Client");

        // Animation loop: Press 'c' to change to a random colored circle, or 'q' to quit
        StdDraw.enableDoubleBuffering();
        System.out.println("Click the window. Press 'c' for random circles, or 'q' to quit.");

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (key == 'q') {
                    break;
                } else if (key == 'c') {
                    // Draw a random circle where the mouse is clicked/hovered
                    double x = StdDraw.mouseX();
                    double y = StdDraw.mouseY();
                    Color randomColor = new Color((int) (Math.random() * 256), 
                                                (int) (Math.random() * 256), 
                                                (int) (Math.random() * 256));
                    StdDraw.setPenColor(randomColor);
                    StdDraw.filledCircle(x, y, 0.5);
                }
            }
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
