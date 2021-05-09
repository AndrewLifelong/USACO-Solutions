import java.io.*;
        import java.util.StringTokenizer;
        import java.util.*;

public class outofplace2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
        int N = Integer.parseInt(br.readLine());
        int[] cowHeights = new int[N];
        int[] inOrder = new int[N];
        for (int i = 0; i < N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int boga = Integer.parseInt(st.nextToken());
            cowHeights[i] = boga;
            inOrder[i] = boga;
        }
        int swaps = 0;
        Arrays.sort(inOrder);
        for (int i = 0; i < N;i++){
            if (cowHeights[i] != inOrder[i]){
                swaps++;
            }
        }
        pw.println(swaps-1);
        pw.close();
        br.close();
    }
}
