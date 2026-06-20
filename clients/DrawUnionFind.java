package clients;

// Demonstrating how to use the StdDraw class
import java.awt.Color;
import edu.princeton.cs.algs4.*;
import data_abstraction.*;
import searching.*;
import java.awt.Rectangle;

import org.w3c.dom.css.Rect;

public class DrawUnionFind {
    private static final double titleX = 25;
    private static final double titleY = 590;
    private static final int canvasWidth = 600;
    private static final int canvasHeight = 600;
    private static final int gap = 20;
    private static int xIndex = 0; // Helper to layout in the x, for now
    private static class Vertex
    {
        int width = 15; 
        int height = 15;
        int id;
        Vertex parent;
        Vertex[] children;
        int nextChildIdx = 0;
        Color color;
        // Default to center, will get updated on layout
        int x = 0;
        int y = canvasHeight-30;
        
        Vertex(int id)
        {
            this.id = id;
            this.parent = this; // Assum each vertex is a root, will get updated as we build out the list
            children = new Vertex[10];
            color = new Color((int) (Math.random() * 256), 
                                                (int) (Math.random() * 256), 
                                                (int) (Math.random() * 256));
        
            x = xIndex + width + gap;
            xIndex = x; 
        
        }
        

        
        public Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }
        
        public void setBounds(Rectangle newBounds)
        {
            x = newBounds.x;
            y = newBounds.y;
            width = newBounds.width;
            height = newBounds.height;
        }

        public Color getColor()
        {
            return color;
        }

        public void setParent(Vertex parent)
        {
            this.parent = parent;
            Rectangle newBounds = parent.getBounds();
            newBounds.y = newBounds.y - newBounds.height-gap; // Move the child below the parent
            // TODO layout X
            this.setBounds(newBounds);
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
            StdDraw.setPenColor(new Color(255, 255, 255));
            StdDraw.text(bounds.getX(), bounds.getY(), Integer.toString(vertex.id));
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
