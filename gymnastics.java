import java.io.*;
import java.util.StringTokenizer;
public class gymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("test.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int count = 0;
        int[][] rankings = new int[K][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                rankings[i][j] = Integer.parseInt(st.nextToken());
                // System.out.println(rankings[i][j]);
            }
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int cow1 = rankings[0][i];
                int cow2 = rankings[0][j];
                // for each pair count how many consistent lines below
                // save the number of consistent lines in pairs
                int pairs = 0;
                // System.out.println(cow1 + " "+cow2);
                for (int x = 1; x < K; x++) {
                    int index1 = 0;
                    int index2 = 0;
                    // we skip x=0 because cows are already read from line 0
                    for (int y = 1; y < N; y++) {
                        if (rankings[x][y] == cow1) {
                            index1 = y;
                        }
                        if (rankings[x][y] == cow2) {
                            index2 = y;
                        }
                        if (index1 != 0 && index2 != 0){
                            break;
                        }
                    }
                    if (index1 < index2) {
                        pairs++;
                    }
                }
                if (pairs == K-1) {
                    count++;
                }
            }
        }
        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
        pw.println(count);
        pw.close();
        br.close();
    }
}