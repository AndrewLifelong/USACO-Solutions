import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;

public class nerdcount {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("test.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        int[] nerds = new int[47];
        Arrays.fill(nerds,0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());
            // update frequency of each time the nerd said something
            nerds[x-1]++;
        }
        for (int j = 0; j < nerds.length;j++){
            pw.println(nerds[j]);
        }
        pw.close();
        br.close();
    }
}
