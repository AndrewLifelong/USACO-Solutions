import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class herding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("herding.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
        int max = 0,min = 0;
        int[] cows = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3;i++){
            cows[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cows);

        if (cows[2] == cows[0]+2 ){
            pw.println(0 + "\n" + 0);
            pw.close();
            br.close();
        }else if (cows[1] == cows[0]+2){
            min = 1;
        }else if (cows[2] == cows[1]+2) {
            min = 1;
        }else{
            min = 2;
        }
        max = Math.max(cows[1]-cows[0],cows[2]-cows[1])-1;
        pw.println(min + "\n" + max);
        pw.close();
        br.close();






    }
}
