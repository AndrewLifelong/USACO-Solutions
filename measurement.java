import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class measurement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        int N = Integer.parseInt(br.readLine());
        int[] days = new int[N];
//        HashMap<String, Integer> map = new HashMap();
        String[] cow = new String[N];
        int[] change = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            cow[i] = st.nextToken();
            change[i] = Integer.parseInt(st.nextToken());
        }
        int bessie = 7;
        int elsie = 7;
        int mildred = 7;
        boolean bessieOn = true, elsieOn = true, mildredOn = true;
        int dayAdjust = 0;
        for (int x = 1; x <= 100; x++) {
            for (int j = 0; j < (N); j++) {
                if (days[j] == (x)) {
//                    System.out.println(days[x]);
                    if (cow[j].equals("Bessie")) {
                        bessie += change[j];
                    }
                    if (cow[j].equals("Elsie")) {
                        elsie += change[j];
                    }
                    if (cow[j].equals("Mildred")) {
                        mildred += change[j];
                    }
                    int highestMilk = Math.max(bessie, Math.max(elsie, mildred));
                    boolean bessieOnNext = bessie == highestMilk;
                    boolean elsieOnNext = elsie == highestMilk;
                    boolean mildredOnNext = mildred == highestMilk;
                    if (bessieOn != bessieOnNext || elsieOn != elsieOnNext || mildredOn != mildredOnNext) {
                        dayAdjust++;
                    }
                    bessieOn = bessieOnNext;
                    elsieOn = elsieOnNext;
                    mildredOn = mildredOnNext;
                }
            }
        }
        pw.println(dayAdjust);
        pw.close();
        br.close();
    }
}
