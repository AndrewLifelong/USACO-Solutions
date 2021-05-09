import java.util.Arrays;
import java.util.*;

public class Lesson1 {
    public static void main(String[] args) {
        int x = 10; // Variable initialization

//        long a = 12319212; // 64 bits
//        int b = 12381023; // 32 bits
        int a = 7;
        int b = 8;
        System.out.print(7+8);
        System.out.print(7+8);
        int c = a+b;
        System.out.println(c);
        // -, *, /, %

        String bob = "builder";
        String subbob = bob.substring(0,4); // The second number is a cap, not included
        System.out.println(subbob);
        String subbob2 = bob.substring(3);
        System.out.println(subbob2);
        char bruh = bob.charAt(2);
        System.out.println(bruh);
        String example = "this is an example code";
        System.out.println(example.indexOf("code"));
        if (example.indexOf("example")!=-1){
            System.out.println("example is in the string");
        } else {
            System.out.println("example is not in the string");
        }
        String length = "hello";
        int len = length.length();
        System.out.println(len);
        // a.equals(b);

        boolean tru = false;
        if (!tru){
            System.out.println("the boolean is false");
        }

        int[] arr = new int[5]; // [ , , , , ]
        int[] arr2 = {1,3,4,5,6};
        arr[4] = 6;
        Arrays.fill(arr2,1);
        for (int i = 0; i < arr2.length;i++){
            System.out.println(arr2[i]);
        }







    }
}
