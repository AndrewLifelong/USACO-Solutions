import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class measurement2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("measurement.in"));//measurement
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        int N = Integer.parseInt(br.readLine());
        int[] cowids = new int[100];
        int[] milk = new int[100];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int id = 0;
            String name = st.nextToken();
            if (name.equals("Bessie")){
                id=1;
            }else if (name.equals("Elsie")){
                id=2;
            }else if (name.equals("Mildred")){
                id=3;
            }
            cowids[day-1] = id;
            int delta = Integer.parseInt(st.nextToken());
            milk[day-1] = delta;
        }
        int b = 7,e = 7,m = 7;
        int changes = 0;
        int max = 7;
        boolean bOn = true, eOn = true, mOn = true;
        boolean bOnNext = false, eOnNext = false, mOnNext = false;
        for (int i = 0; i < 100;i++){
            if (cowids[i] != 0){
                if (cowids[i] == 1){
                    b += milk[i];
                }else if (cowids[i] == 2){
                    e+=milk[i];
                }else if (cowids[i] == 3){
                    m+=milk[i];
                }
                max = Math.max(b, Math.max(e, m));
                bOnNext = (b == max);
                eOnNext = (e == max);
                mOnNext = (m == max);
                if (bOnNext != bOn || eOnNext!= eOn || mOnNext != mOn){
                    changes++;
                }
                bOn = bOnNext;
                eOn = eOnNext;
                mOn = mOnNext;
            }
        }
        pw.println(changes);
        pw.close();
        br.close();
    }
}