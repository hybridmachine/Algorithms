import java.util.Random;

//import searching.symboltables.rbBST.RedBlackBST_BT;

public class TestRedBlackBST_BT {

    public static void main(String []args)
    {
        if (args.length < 1)
        {
            System.out.println("Usage: java TestRedBlackBST_BT <number of keys>");
            return;
        }
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rng = new Random();

        RedBlackBST_BT<String, Integer> rbBST = new RedBlackBST_BT<String, Integer>();
        int genSize = Integer.parseInt(args[0]);
        for (int idx = 0; idx < genSize; idx++)
        {
            //String key = generateString(rng, characters, 5);
            rbBST.put(generateString(rng, characters, 5), idx);
        }

        System.out.println("Red node count: " + rbBST.countRedNodes());
        rbBST.printStatistics();

        System.out.println("Height growth test");

        StringBuilder growthReportBld = new StringBuilder();
        growthReportBld.append("Size, Height\n");

        int jump = genSize / 40;
        for (int size = 0; size <= genSize; size += jump)
        {
            rbBST = new RedBlackBST_BT<String, Integer>();
            //String key = generateString(rng, characters, 5);
            for (int idx = 0; idx < size; idx++)
            {
                //String key = generateString(rng, characters, 5);
                rbBST.put(generateString(rng, characters, 5), idx);
            }
            growthReportBld.append(size).append(",").append(rbBST.getHeight()).append('\n');
        }

        System.out.print(growthReportBld.toString());

    }

    // Source - https://stackoverflow.com/a
    // Posted by Jon Skeet
    // Retrieved 2026-01-07, License - CC BY-SA 2.5

    public static String generateString(Random rng, String characters, int length)
    {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

}
