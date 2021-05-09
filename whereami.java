import java.io.*;
import java.util.ArrayList;

public class whereami {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
            // read in input
            String colors = br.readLine();
            int N = Integer.parseInt(br.readLine());
            ArrayList<String> arr = new ArrayList<String>();
            int count = 0;
            boolean flag;
            // tests each K
            for (int i = 1; i <= N; i++) {
                flag = true;
                // finds substrings of k length
                for (int j = 0; j <= N-i; j++) {
                    String sub = colors.substring(j, j + i);
                    arr.add(sub);
                }
                // checks for duplication
                for (int j = 0; j < arr.size(); j++) {
                    String k1 = arr.get(j);
                    for (int x = 0; x < arr.size(); x++) {
                        String k2 = arr.get(x);
                        if (j != x && k1.equals(k2)) {
                            flag = false;
                            break;
                        }
                    }
                }
                // finds if = k
                if (flag) {
                    count = i;
                    break;
                }
                // removes elements
                arr.clear();
            }
            pw.println(count);
            pw.close();
            br.close();
        }
    }
