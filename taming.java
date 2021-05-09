import java.io.*;
import java.util.StringTokenizer;

public class taming {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("taming.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (arr[0] != 0 && arr[0] != -1){
            // The first entry must be 0 or -1, otherwise it's inconsistent and we return -1.
            pw.println(-1);
            pw.close();
            br.close();
        }
        boolean flag = false;
        int breakouts = 0;
        arr[0] = 0;
        int min = 0;
        int max = 0;
        int prev = 0;
        for (int i = N-1; i >= 0; i--) {
            if (arr[i] > 0) {
                if (!flag) {
                    // Find a new positive number
                    flag = true;
                    prev = arr[i];
                } else {
                    if (arr[i] != prev - 1) {
                        // Inconsistency, return -1
                        pw.println(-1);
                        pw.close();
                        br.close();
                        return;

                    }else{
                        prev = arr[i];
                    }
                }
            } else {
                if (arr[i] == 0) {
                    flag = false;
                    prev = 0;
                } else {
                    // -1 case
                    if (flag){
                        arr[i] = prev - 1;
                        prev = arr[i];
                        if (arr[i] == 0){
                            // After update if the current one is 0 we restart the search
                            flag = false;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++){
            if (arr[i] == 0){
                min++;
            }
            if (arr[i] == -1){
                max++;
            }
        }
        max += min;
        pw.println(min + " " + max);
        pw.close();
        br.close();

    }
}
