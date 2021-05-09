import java.io.*;
import java.util.StringTokenizer;

public class max {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("max.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("max.out")));
        int N = Integer.parseInt(br.readLine());
        // reads in integer N, stores as variable
        // This next loop reads each n lines and splits them by semicolons and checks if they are greater than the previous maximum value.
        int maxa = 0;
        int maxb = 0;
        int maxc = 0;
        // we initialize the variables that will store the max value each time.
        int indexa = 0;
        int indexb = 0;
        int indexc = 0;
        // we initialize varibles that hold the index of the maximum value
        for (int i = 0; i < N; i++){
            String values = br.readLine();
            String[] max = values.split(";");
            int testa = Integer.parseInt(max[0]);
            int testb = Integer.parseInt(max[1]);
            int testc = Integer.parseInt(max[2]);
            // In these 3 if statements, we compare the current maximum value to the new value we read in.
            // If the new value is greater than the maximum value, we set the maximum value to the new value and read its index each time.
            if (testa > maxa){
                maxa = testa;
                indexa = i;
            }
            if (testb > maxb){
                maxb = testb;
                indexb = i;
            }
            if (testc > maxc){
                maxc = testc;
                indexc = i;
            }
        }
        // we print the answer
        pw.println(indexa +" "+ indexb +" "+ indexc);
        pw.close();
        br.close();
    }
}
