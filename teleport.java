import java.io.*;
import java.util.*;
public class teleport {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("test.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int distance = 0;
        int xtp = Math.abs(Math.abs(a-x)+Math.abs(b-y));
        int ytp = Math.abs(Math.abs(a-y)+Math.abs(b-x));
        int ab = Math.abs(a-b);
        distance = Math.min(ab, Math.min(xtp,ytp));
        pw.println(distance+1);
        pw.close();
        br.close();
    }
}
