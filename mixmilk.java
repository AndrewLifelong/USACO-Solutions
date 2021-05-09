import java.io.*;
import java.util.StringTokenizer;

public class mixmilk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
        int[] maxCap = new int[3];
        int[] amount = new int[3];
        // arrays for amount in bucket and max capacities
        for (int i = 0; i < 3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            maxCap[i] = Integer.parseInt(st.nextToken());
            amount[i] = Integer.parseInt(st.nextToken());
            //  read in the data
        }
        int curr, next, curramt;
        for (int i = 0; i < 100;i++){
            curr = i%3;
            if (curr<2){
                next = curr+1;
            }else{
                next = 0;
            }
            curramt = Math.min(amount[curr], maxCap[next] - amount[next]);
            System.out.println(curramt);
            amount[curr] -= curramt;
            amount[next] += curramt;
        }
        for(int i = 0; i < 3;i++){
            pw.println(amount[i]);
        }
        pw.close();
        br.close();
    }
}
