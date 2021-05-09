import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class guess {
    public static void main(String[] args) throws IOException {
        ArrayList[] trs;
        BufferedReader br = new BufferedReader(new FileReader("test.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        int N = Integer.parseInt(br.readLine());
        int gtr = 0;
        HashMap <String, Integer> map = new HashMap<>();
        trs = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            trs[i] = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int T = Integer.parseInt(st.nextToken());
            for (int t = 0; t < T; t++) {
                String trt = st.nextToken();
                if (!map.containsKey(trt))
                    map.put(trt, gtr++);
                trs[i].add(map.get(trt));
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) { // ask about the traits in common, then ask one more to
                res = Math.max(res, overlap(trs[i], trs[j]));// differentiate
            }
        }
        pw.println(res + 1);
        pw.close();
        br.close();
    }
    public static int overlap(ArrayList<Integer> A, ArrayList<Integer> B) {
        int res = 0;
        for (int a : A)
            for (int b : B)
                if (a == b) {
                    res++;
                    break;
                }
        return res;
    }
}


