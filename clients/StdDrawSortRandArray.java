// Demonstrating how to use the StdDraw class
import java.awt.Color;
import java.util.Arrays;
import data_abstraction.*;
import edu.princeton.cs.algs4.*;

public class StdDrawSortRandArray {
    public static void main(String[] args) {
        // Set the canvas size (in pixels)
        StdDraw.setCanvasSize(600, 600);

        // Set the scale of the coordinate system (x and y from 0 to 10)
        StdDraw.setScale(0, 1);

        int n = 50;
        double[] a = new double[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniformDouble();
        Arrays.sort(a);
        
        for (int i = 0; i < n; i++)
        {
            double x = 1.0*i/n;
            double y = a[i]/2.0;
            double rw = 0.5/n;
            double rh = a[i]/2.0;
            StdDraw.filledRectangle(x,y,rw,rh);
        }
        
        StdDraw.show();
        
        while (true) {
            StdDraw.pause(20);
        }
    }
}
