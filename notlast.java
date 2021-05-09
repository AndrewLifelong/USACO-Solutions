import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.*;

public class notlast {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));

        int N = Integer.parseInt(br.readLine());
//        HashMap<String, Integer> map= new HashMap();
//        map.put("bob", 5);


        HashMap<String, Integer> map = new HashMap();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)) {
                map.replace(key, map.get(key)+value);
            } else {
                map.put(key, value);
            }
        }

        //System.out.println(map);

        int numOfKeys = map.keySet().size();
        if (numOfKeys < 7){
            map.put("dummy", 0);
        }

        //System.out.println(map);

        ArrayList<Integer> l = new ArrayList();
        for (int val : map.values()) {
            l.add(val);
        }
        Collections.sort(l);

        //System.out.println(l);

        int min = l.get(0);
        int start = -1;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) != min) {
                start = i;
                break;
            }
        }
        if (start == -1) {
            pw.println("Tie");
            pw.close();
            br.close();
            return;
        }

        if (start+1 < l.size() && l.get(start+1) == l.get(start)) {
            pw.println("Tie");
            pw.close();
            br.close();
            return;
        }

        //System.out.println(l.get(start));
//        System.out.println(l);
//        System.out.println(start);
//        System.out.println(l.get(start));

        String result = "";
        for (String key : map.keySet()) {
//            System.out.println(l.get(start) + "-" + key + " - " + map.get(key));
//            System.out.println(l.get(start));
            int val = map.get(key);
            int match = l.get(start);
            if (val == match) {
                //System.out.println("bob");
                result = key;
            }
        }

        //System.out.println("result:" + result);

        pw.println(result);
        pw.close();
        br.close();
        return;
    }
}
