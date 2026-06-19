package clients;

// Demonstrating how to use the StdDraw class
import java.awt.Color;
import edu.princeton.cs.algs4.*;
import data_abstraction.*;
import searching.*;
import java.awt.Rectangle;

import org.w3c.dom.css.Rect;

public class DrawUnionFind {
    private static final double titleX = 2.5;
    private static final double titleY = 19.5;
    private static final int canvasWidth = 600;
    private static final int canvasHeight = 600;
    private static final int scale = 20;
    private static class Vertex
    {
        int width = 45; 
        int height = 45;
        int id;
        Vertex parent;
        Vertex[] children;
        int nextChildIdx = 0;
        Color color;

        Vertex(int id)
        {
            this.id = id;
            this.parent = this; // Assum each vertex is a root, will get updated as we build out the list
            children = new Vertex[10];
            color = new Color((int) (Math.random() * 256), 
                                                (int) (Math.random() * 256), 
                                                (int) (Math.random() * 256));
        }
        
        // Default to center, will get updated on layout
        int x = canvasWidth/2;
        int y = canvasHeight/2;
        
        public Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }
        
        public Color getColor()
        {
            return color;
        }

        public void setParent(Vertex parent)
        {
            this.parent = parent;
        }
        
        public void addChild(Vertex child)
        {
            if (nextChildIdx < children.length - 1)
            {
                children[nextChildIdx] = child;
                child.setParent(this);
                nextChildIdx++;
            }
        }
    }
    
    public static void main(String[] args) {
        // Set the canvas size (in pixels)
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);

        // Set the scale of the coordinate system (x and y from 0 to 10)
        StdDraw.setScale(0, canvasWidth);

        // Display text in black
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(titleX, titleY, "Draw Union Find");

        int N = StdIn.readInt();
        Vertex []nodes= new Vertex[N];
        
        WeightedQuickUnionUFBT uf = new WeightedQuickUnionUFBT(N);
        
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p,q)) continue;
            
            uf.union(p,q);
            StdOut.println(p + " " + q);
        }
        
        for (int idx = 0; idx < N; idx++)
        {
            if (nodes[idx] == null) 
                nodes[idx] = new Vertex(idx);
                
            int forrestRoot = uf.find(idx);
            if (nodes[forrestRoot] == null)
                nodes[forrestRoot] = new Vertex(forrestRoot);
                
            int parent = uf.parent(idx);
            if (nodes[parent] == null)
                nodes[parent] = new Vertex(parent);
                
            nodes[parent].addChild(nodes[idx]);
        }
        
        // Animation loop: Press 'c' to change to a random colored circle, or 'q' to quit
        StdDraw.enableDoubleBuffering();
        System.out.println("Click the window. Press 'c' for random circles, or 'q' to quit.");

        for (Vertex vertex : nodes)
        {
            Color drawColor = vertex.getColor();
            StdDraw.setPenColor(drawColor);
            Rectangle bounds = vertex.getBounds();

            StdDraw.filledCircle(bounds.getX(), bounds.getY(), bounds.height);
        }

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
                    StdDraw.filledCircle(x, y, 45);
                } else if (key == 'e') {
                    StdDraw.clear();  
                    // Display text in black
                    StdDraw.setPenColor(Color.BLACK);
                    StdDraw.text(titleX, titleY, "Draw Union Find");               
                }
            }
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
