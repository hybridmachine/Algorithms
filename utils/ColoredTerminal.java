package utils;

public class ColoredTerminal {
    // ANSI escape code strings for colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public static final String BLACK_BG = "\u001B[40m";
    public static final String WHITE_BG = "\u001B[47m";
    
    public static String colorstr(String color, String background, String text)
    {
        if (background == null)
            background = "";

        return color + background + text + RESET;
    } 

    public static void main(String[] args) {
        // Print text with a specific color and reset immediately after
        System.out.println(colorstr(RED, WHITE_BG, "This") + " text is " + colorstr(RED, BLACK_BG, "red!"));
        System.out.println(GREEN + "This text is green!" + RESET);
        System.out.println(YELLOW + "This text is yellow!" + RESET);
        
        // Combining text color and background color
        System.out.println(BLUE + WHITE_BG + "Blue text on a white background!" + RESET);
    }
}
