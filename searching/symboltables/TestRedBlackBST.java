import edu.princeton.cs.algs4.RedBlackBST;

public class TestRedBlackBST {

    public static void main(String []args)
    {
        RedBlackBST<String, Integer> rbBST = new RedBlackBST<String, Integer>();

        int val = 0;
        rbBST.put("S", ++val);
        rbBST.put("E", ++val);
        rbBST.put("A", ++val);
        rbBST.put("R", ++val);
        rbBST.put("C", ++val);
        rbBST.put("H", ++val);

        for (String key : rbBST.keys())
        {
            System.out.println("Key " + key + " value " + rbBST.get(key));
        }
    }
}
