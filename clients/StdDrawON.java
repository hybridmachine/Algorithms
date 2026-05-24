// Demonstrating how to use the StdDraw class
import java.awt.Color;

public class StdDrawON {
    public static void main(String[] args) {
        // Set the canvas size (in pixels)
        StdDraw.setCanvasSize(600, 600);

        // Set the scale of the coordinate system (x and y from 0 to 10)
        StdDraw.setScale(0, 10);

        int n = 100;
        StdDraw.setXscale(0,n);
        StdDraw.setYscale(0,n*n);
        StdDraw.setPenRadius(0.01);
        for (int i = 1; i <= n; i++)
        {
            StdDraw.point(i,i);
            StdDraw.point(i,i*i);
            StdDraw.point(i,i*Math.log(i));
        }
        
        StdDraw.show();
        
        while (true) {
            StdDraw.pause(20);
        }
    }
}
