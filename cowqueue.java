import java.io.*;
        import java.util.StringTokenizer;
        import java.util.*;

public class cowqueue {
    static TreeMap<Integer, Integer> multiset = new TreeMap<Integer, Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrive = Integer.parseInt(st.nextToken());
            int cross = Integer.parseInt(st.nextToken());
            add(arrive,cross);
        }
        int currtime = 0;
        Set<Integer> keys = multiset.keySet();
        for (int key: keys){
            if (key == multiset.firstKey()){
                currtime = key;
                currtime += multiset.get(key);
            }else{
                if(currtime < key){
                    currtime = key;
                    currtime += multiset.get(key);
                }else if (currtime > key){
                    currtime += multiset.get(key);
                }else if (currtime == key){
                    currtime += multiset.get(key);
                }
            }
        }
        pw.println(currtime);
        pw.close();
        br.close();
    }

    static void add(int key, int val){
        if(multiset.containsKey(key)){
            multiset.put(key, multiset.get(key) + val);
        } else {
            multiset.put(key, val);
        }
    }
}









