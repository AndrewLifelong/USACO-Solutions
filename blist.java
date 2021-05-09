import java.io.*;
import java.util.StringTokenizer;

public class blist {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("blist.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
        int N = Integer.parseInt(br.readLine());
        int[] timestart = new int[N];
        int[] timeend = new int[N];
        int[] bucket = new int[N];
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            timestart[i] = Integer.parseInt(st.nextToken());
            timeend[i] = Integer.parseInt(st.nextToken());
            bucket[i] = Integer.parseInt(st.nextToken());
        }
        int buckets = 0;
        for (int i = 0; i < 1000; i++) {
            int currbuckets = 0;
            for (int j = 0; j < N; j++) {
                if (timestart[j] <= i && i <= timeend[j]) {
                    currbuckets += bucket[j];
                }
            }
            buckets = Math.max(buckets,currbuckets);
        }
        pw.println(buckets);
        pw.close();
        br.close();

    }
}
