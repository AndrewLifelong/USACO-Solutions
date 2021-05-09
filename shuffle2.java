import java.io.*;
import java.util.StringTokenizer;

public class shuffle2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] rule = new int[N+1];
        for (int i = 1; i <= N; i++){
            int number = Integer.parseInt(st.nextToken());
            rule[number] = i;
        }
        int[] ids = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N;i++){
            ids[i] = Integer.parseInt(st.nextToken());
        }
        int[] ret = new int[N+1];
        for(int i = 1; i <= N; i++){
           int index = i;
           for (int j = 0; j < 3; j++){
               index = rule[index];
           }
            ret[index] = ids[i];
        }
        for (int i = 1; i <= N;i++){
            pw.println(ret[i]);
        }
        pw.close();
        br.close();
    }
}
