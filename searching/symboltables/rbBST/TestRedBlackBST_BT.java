import java.util.Random;

//import searching.symboltables.rbBST.RedBlackBST_BT;

public class TestRedBlackBST_BT {

    public static void main(String []args)
    {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rng = new Random();

        RedBlackBST_BT<String, Integer> rbBST = new RedBlackBST_BT<String, Integer>();

        for (int idx = 0; idx < Integer.parseInt(args[0]); idx++)
        {
            String key = generateString(rng, characters, 5);
            rbBST.put(key, idx);
        }

        System.out.println("Red node count: " + rbBST.countRedNodes());
        
        //for (String key : rbBST.keys())
        //{
        //    System.out.println("Key " + key + " value " + rbBST.get(key));
        //}
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
