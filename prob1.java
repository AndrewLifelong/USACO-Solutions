import java.util.*;
import java.io.*;
public class prob1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cow = scanner.nextLine();
        String heard = scanner.nextLine();
        // System.out.println(cow + " " + heard);
        int ret = 1;
        String check;
        int index = 0;
        for (int i = 0; i <= heard.length()-1; i++){
            if (i == 0){
                check = heard.substring(i,i+1); //m
                index = cow.indexOf(check); //12
            }else{
                check = heard.substring(i,i+1); // D
                int compare = cow.indexOf(check); // 3
                if (compare <= index){
                    ret++;
                }
                index = cow.indexOf(check);
            }

        }
        System.out.println(ret);
    }
}