import java.io.*;
import java.util.StringTokenizer;

public class word2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("word.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int linesize = 0;
        StringBuilder sb = new StringBuilder();
        String line = null;
        for (int i = 0; i < N;i++){
            line = st.nextToken();
            if (i == 0){
                sb.append(line);
                linesize += line.length();
                continue;
            }
            if(linesize + line.length() > K){
                linesize = line.length();
                sb.append("\n");
                sb.append(line);
            } else {
                linesize += line.length();
                sb.append(" "+line);
            }
        }
        pw.println(sb.toString());
        br.close();
        pw.close();
    }
}
