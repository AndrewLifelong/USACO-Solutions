import java.io.*;
import java.util.StringTokenizer;

public class race {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("test.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] x = new int[N];
        for (int i = 0; i < N;i++){
            x[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N;i++){

        }





    }
}

