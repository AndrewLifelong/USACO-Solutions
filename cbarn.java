import java.io.*;
import java.util.StringTokenizer;

public class cbarn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        int N = Integer.parseInt(br.readLine());
        int[] rooms = new int[N];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            rooms[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N;i++){
            int total = 0;
            for (int j = 0; j < N;j++){
                int sum = i+j;
                if ((sum) >=  N){
                    sum = sum%N;
                }
                total+=rooms[sum]*j;
            }
            min = Math.min(min,total);
        }
        pw.println(min);
        pw.close();
        br.close();
    }
}