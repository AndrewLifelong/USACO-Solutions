import java.io.*;
import java.util.StringTokenizer;

public class promote {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("promote.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
        int[] before = new int[4],after = new int[4];
        for (int i = 0; i < 4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            before[i] = Integer.parseInt(st.nextToken());
            after[i] = Integer.parseInt(st.nextToken());
        }
        int goldtoplat = (after[3]-before[3]);
        int silvtogold = goldtoplat+(after[2]-before[2]);
        int bronzetosilv = silvtogold+(after[1]-before[1]);
        pw.println(bronzetosilv + "\n" + silvtogold + "\n" + goldtoplat);
        pw.close();
        br.close();
    }
}
