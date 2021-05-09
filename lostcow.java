import java.io.*;
import java.util.StringTokenizer;

public class lostcow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int pos = 1;
        int dist = 0;
        int addpos = 1;
        while (true) {
            if ((pos==1 && x<=y && y<=x+addpos) || (pos==-1 && x-addpos<=y && y<=x)){
                dist += Math.abs(x-y);
                pw.println(dist);
                pw.close();
                br.close();
                break;
            }else{
                dist+=addpos*2;
                addpos *= 2;
                pos *= -1;
            }
        }
    }
}
