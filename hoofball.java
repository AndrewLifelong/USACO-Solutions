import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hoofball {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hoofball.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        pw.println(solve(arr));
        pw.close();
        br.close();
    }
    public static int solve(int[] vals) {
        int n = vals.length;
        // Get this case out of the way.
        if (n < 3) return 1;
        // Store which way each cow will pass the ball.
        boolean[] right = new boolean[n];
        right[0] = true;
        // We go right if the left distance is greater than the right distance.
        for (int i=1; i<n-1; i++) {
            if (vals[i] - vals[i - 1] > vals[i + 1] - vals[i]) {
                right[i] = true;
            }
        }
        int res = 0;// i = 0;
        for (int i = 0; i < n;i++){
            System.out.println(right[i]);
        }
        boolean prev = true;
        boolean curr  = false;
        int rCnt = 1;
        int lCnt = 0;
        // Sweep through the data.
        for (int i = 1; i < n; i++){
            // Rights.
            curr = right[i];
            if (prev == false && curr == true) {
                // new streak
                if (rCnt > 1 && lCnt > 1) {
                    // We must come from both sides.
                    res += 2;
                } else {
                    // Good enough to come from one side.
                    res++;
                }
                rCnt = 0;
                lCnt = 0;
            }
            if (curr) {
                rCnt++;
            }else{
                lCnt++;
            }
            prev = curr;
        }
        if (rCnt > 1 && lCnt > 1) {
            // We must come from both sides.
            res += 2;
        }else{
            // Good enough to come from one side.
            res++;
        }
        return res;
    }
}