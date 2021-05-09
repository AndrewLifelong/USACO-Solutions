import java.io.*;
import java.util.StringTokenizer;

public class cowsignal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // We read in the parameters for the signal, and stretch it.


        for (int i = 0; i < M; i++){
            String line = br.readLine();
            String output = "";
            for (int j = 0; j < N; j++) {
                // We can use a nested variable because the limitation is only 100, so our code speed it fine.
                for (int k = 0; k < K; k++){
                    output += line.charAt(j);
                    // We read each character and stretch by factir of K, and stretch each line horozontally by N to amplify in both directions.
                    // System.out.println(output);
                }
            }

            for (int j = 0; j < K; j++) {
                pw.println(output);
            }

        }
        pw.close();
        br.close();
    }
}
