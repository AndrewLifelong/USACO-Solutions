import java.util.*;
import java.io.*;
public class prob2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++){
            arr[i] = scanner.nextInt();
        }
        int ret = 0;
        int evens = 0;
        int odds = 0;
        for (int i = 0; i < N; i++){
            if (arr[i]%2==0){
                evens++;
            }else{
                odds++;
            }
        }
        if (odds == 0){
            // no odds --> 1 even group
            ret = 1;
        }else if (evens == 0) {
            if (odds == 2 || odds == 4){
                ret = 1;
            }else if (odds == 3){
                ret = 2;
            }else{
                int temp = odds;
                int deduct = 2;
                while (temp > 4) {
                    temp -= deduct;
                    ret++;
                    if (deduct == 2){
                        deduct = 1;
                    }else{
                        deduct = 2;
                    }
                }
                ret++;
            }
        }else{
            boolean flag = true;
            while(evens != 0 && odds != 0){
                if (flag){
                    evens--;
                    ret++;
                }else{
                    odds--;
                    ret++;
                }
                flag = !flag;
            }
            if (odds == 0){
                ret++;
            }else{
                // remaining are all odd --> same case as before
                if (odds == 2 || odds == 4){
                    ret = 1;
                }else if (odds == 3){
                    ret = 2;
                }else{
                    int temp = odds;
                    int deduct = 2;
                    if (!flag){
                        deduct = 1;
                    }else{
                        deduct = 2;
                    }
                    while (temp > 4) {
                        temp -= deduct;
                         if (deduct == 2){
                            deduct = 1;
                        }else{
                            deduct = 2;
                        }
                    }
                    if (temp == 3){
                        ret+=2;
                    }else if (temp == 4 || temp == 2){
                        ret++;
                    }else if (temp == 1){
                        ret++;
                    }
                }

            }
        }
        System.out.println(ret);
    }
}