import java.util.*;
import java.io.*;
public class prob3 {
    static long count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] a = new long[N];
        long[] b = new long[N];
        for (int i = 0; i < N; i++){
            a[i] = scanner.nextLong();
        }
        for (int i = 0; i < N; i++){
            b[i] = scanner.nextLong();
        }
        System.out.println(eff(a,b));
        // fuck you usaco
    }

    public static long eff(long[] a, long[] b){
        // sort both arrays first for more efficient linear scan
        Arrays.sort(a);
        Arrays.sort(b);
        count = 1;
        for (int i = a.length-1; i >= 0; i--){
            long temp = find(b,a[i]);
            if (temp == 0){
                return 0;
            }else{
                count = count * (temp-a.length+i+1);
            }  ` `
        }
        return count;

    }
    public static long find(long[] c, long d){
        long cnt = 0;
        for (int i = c.length-1; i >= 0; i--){
            if(c[i] >= d){
                cnt++;
            }else{
                break;
            }
        }
        return cnt;
    }

    // Old bandwidth solution

//    public static long generate(long[] arr, int k, long[] brr) {
//        if (k == 1) {
//            if (check(arr,brr)){
//                count++;
//            }
//        }else{
//            generate(arr,k-1,brr);
//            for (int i = 0; i < k-1;i++){
//                if (k % 2 == 0){
//                    swap(arr,i,k-1);
//                }else{
//                    swap(arr,0,k-1);
//                }
//                generate(arr,k-1,brr);
//            }
//        }
//        return count;
//    }
//    static boolean check(long[] cows, long[] stalls){
//        for (int i = 0; i < cows.length; i++){
//            if (cows[i] > stalls[i]){
//                return false;
//            }
//        }
//        return true;
//    }
//    static void swap(long[] arr, int i, int k){
//        long temp = arr[i];
//        arr[i] = arr[k];
//        arr[k] = temp;
//    }
}