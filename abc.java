import java.util.*;
import java.io.*;
public class abc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> abc = new ArrayList<Integer>();
        for (int i = 0; i < 7; i++){
            abc.add(scanner.nextInt());
        }
        scanner.close();
        int a = 0,b=0,c=0;
        int flag = 0;
        for (int i = 0; i < 7; i++){
            for (int j = i+1; j < 7; j++){
                for (int k = j+1; k < 7; k++){
                    flag = 0;
                    a = abc.get(i);
                    b = abc.get(j);
                    c = abc.get(k);
//                    System.out.println(a+" "+b+" "+c);
                    if(abc.contains(a)){
                        flag++;
                    }
                    if(abc.contains(b)){
                        flag++;
                    }

                    if(abc.contains(c)){
                        flag++;
                    }
                    if(abc.contains(a+b)){
                        flag++;
                    }
                    if(abc.contains(c+b)){
                        flag++;
                    }
                    if(abc.contains(a+c)){
                        flag++;
                    }
                    if(abc.contains(a+b+c)){
                        flag++;
                    }
                    if (flag == 7){
                        break;
                    }
                }
                if (flag == 7){
                    break;
                }
            }
            if (flag == 7){
                break;
            }
        }
        int[] abcs = {a,b,c};
        Arrays.sort(abcs);
        System.out.println(abcs[0] + " " + abcs[1] + " " + abcs[2]);
    }
}
