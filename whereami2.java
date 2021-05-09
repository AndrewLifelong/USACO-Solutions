import java.io.*;
import java.util.HashSet;

public class whereami2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
        int N = Integer.parseInt(br.readLine());
        String colors = br.readLine();
        int k;
        int mink = 0;
        boolean stop = true;
        HashSet<String> set = new HashSet<String>();
        for (k = 1; k <= N; k++) {
            for (int j = 0; j <= N - k; j++) {
                String sub = colors.substring(j, j + k);
                if (!set.contains(sub)){
                    set.add(sub);
                }else{
                    set.clear();
                    break;
                }
                if (j == (N-k)){
                    mink = k;
                    stop = false;
                }
            }
            if(!stop){
                break;
            }
        }
        pw.println(mink);
        pw.close();
        br.close();
    }
}
