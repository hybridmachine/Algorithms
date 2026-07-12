package clients;
/*
 * Visualize sorting based on the graphical example on page 253 of Algorithms by Robert Sedgewick
 */

import java.awt.Color;
import java.awt.Font;
import edu.princeton.cs.algs4.*;
import java.awt.Rectangle;
import sorting.ISortStepDisplayer;
import sorting.SelectionSort;

public class VisualizeSorting implements ISortStepDisplayer {
    private static final int canvasWidth = 600;
    private static final int canvasHeight = 600;
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public void showStep(Comparable []a)
    {
        StdDraw.clear();
        double max = Double.MAX_VALUE;
        if (a[0] instanceof String)
        {
            max = 26.0;
            for (int idx = 0; idx < a.length; idx++)
            {
                int height = alphabet.indexOf(a[idx].toString().toLowerCase());
                StdOut.println(a[idx] + " " + Integer.toString(height));
            }

            StdOut.println("----------------------------------");
            StdOut.println();
        }
    }

    public static void main(String[] args) {
        // Set the canvas size (in pixels)
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setTitle("Visualize Sorting");
        
        // Set the scale of the coordinate system (x and y from 0 to 10)
        StdDraw.setScale(0, canvasWidth);

        // Display text in black
        StdDraw.setPenColor(Color.BLACK);

        StdDraw.show();
        SelectionSort sorter = new SelectionSort(StdIn.readAllStrings());
        sorter.setSortStepDisplayer(new VisualizeSorting());
        sorter.sort();
        assert sorter.isSorted();
        sorter.show();

        while (true) {
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
