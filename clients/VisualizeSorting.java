package clients;
/*
 * Visualize sorting based on the graphical example on page 253 of Algorithms by Robert Sedgewick
 */

import java.awt.Color;
import java.awt.Font;
import edu.princeton.cs.algs4.*;
import java.awt.Rectangle;
import sorting.ISortStepDisplayer;
import sorting.InsertionSort;
import sorting.SelectionSort;

public class VisualizeSorting implements ISortStepDisplayer {
    private static final int canvasWidth = 600;
    private static final int canvasHeight = 600;
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public void showStep(Comparable []previous, Comparable []current, int i, int min)
    {
        double max = Double.MAX_VALUE;
        if (current[0] instanceof String)
        {
            max = 26.0;
            StdDraw.setYscale(0, max*4);
            Comparable [][]beforeAfter = new Comparable[2][];
            beforeAfter[0] = previous;
            beforeAfter[1] = current;
            for (Comparable []a : beforeAfter)
            {
                for (int idx = 0; idx < a.length; idx++)
                {
                    int x = (idx * (canvasWidth/a.length)) + 15;
                    int height = alphabet.indexOf(a[idx].toString().toLowerCase()) + 1;
                    StdOut.println(a[idx] + " " + Integer.toString(height));
                    Color activePenColor = StdDraw.getPenColor();
                    if (i != min){
                        Color iColor = Color.RED;
                        Color minColor = Color.MAGENTA;
                        Color backgroundColor = StdDraw.getBackgroundColor();
                        if (a == previous)
                        {
                            // Swap the colors for displaying previous
                            Color temp = iColor;
                            iColor = minColor;
                            minColor = temp;
                        }
                        if (idx == i || idx == min)
                        {
                            // Blank out the current position
                            StdDraw.setPenColor(backgroundColor);
                            StdDraw.filledRectangle(x, max, 10, 2.0 * max);
                        }
                        if (idx == i)
                        {
                            StdDraw.setPenColor(iColor);
                        }
                        else if (idx == min)
                        {
                            StdDraw.setPenColor(minColor);
                        }     
                        StdDraw.filledRectangle(x, height + 1, 10, height);
                        StdDraw.text(x, height + height + 3, a[idx].toString());               
                    }

                    StdDraw.setPenColor(activePenColor); 
                }
                StdDraw.pause(250);
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
        StdDraw.setPenColor(Color.BLUE);

        StdDraw.show();
        InsertionSort sorter = new InsertionSort(StdIn.readAllStrings());
        sorter.setSortStepDisplayer(new VisualizeSorting());
        sorter.sort();
        assert sorter.isSorted();
        sorter.show();

        while (true) {
            StdDraw.pause(20);
        }
    }
}
