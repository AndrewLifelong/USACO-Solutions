import java.io.*;
import java.util.*;

public class evolution {
    static int N;
    static ArrayList<String>[] chars = new ArrayList[25];
    static ArrayList<String> allChars = new ArrayList<String>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("evolution.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("evolution.out")));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            chars[i] = new ArrayList<String>();
            for (int j = 0; j < K; j++){
                String s = st.nextToken();
                chars[i].add(s);

                boolean f = false;
                for (int k = 0; k < allChars.size();k++){
                    if (allChars.get(k).equals(s)){
                        f = true;
                        break;
                    }
                }
                if (!f){
                    allChars.add(s);
                }
            }
        }
        int size = allChars.size();
        boolean ret = true;
        for (int i = 0; i < size; i++){
            for (int j = i+1; j < size; j++){
                if(crossing(i,j)){
                    ret = false;
                }
            }
        }
        if (!ret){
            pw.println("no");
        }else if (ret){
            pw.println("yes");
        }
        pw.close();
        br.close();
    }
    public static boolean crossing(int a, int b){
        int A=0,B=0,AB=0;
        for (int i = 0; i < N; i++){
            ArrayList<String> vector = chars[i];
            boolean hasa = false;
            boolean hasb = false;
            for (int j = 0; j < vector.size();j++){
                if(vector.get(j).equals(allChars.get(a))){
                    hasa = true;
                }
                if(vector.get(j).equals(allChars.get(b))){
                    hasb = true;
                }
            }
            if (hasa && hasb) {
                AB++;
            }else if (hasa){
                A++;
            } else if (hasb) {
                B++;
            }
        }
        if (AB>0 && A>0 && B>0){
            return true;
        }
        return false;
    }
}
