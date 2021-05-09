import java.io.*;
import java.util.*;

public class backforth {
    static int[] poss = new int[2000];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> B1 = new ArrayList<Integer>();
        ArrayList<Integer> B2 = new ArrayList<Integer>();
        Arrays.fill(poss,0);
        for(int i = 0; i < 10; i++){
            B1.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 10; i++) {
            B2.add(Integer.parseInt(st.nextToken()));
        }
        tuesday(1000, B1, B2);
        int answer = 0;
        for (int i = 0; i < 2000;i++){
            answer+=poss[i];
        }
        pw.println(answer);
        pw.close();
        br.close();
    }
    public static void tuesday(int milk, ArrayList<Integer> one, ArrayList<Integer> two)
    {
        for(int i = 0; i < one.size(); i++)
        {
            int x = one.get(i);
            ArrayList twoNew = new ArrayList<Integer>();
            twoNew = (ArrayList)two.clone();
            twoNew.add(x);
            ArrayList oneNew = new ArrayList<Integer>();
            oneNew = (ArrayList)one.clone();
            oneNew.remove(i);
            wednesday(milk - x, oneNew, twoNew);
        }
    }
    public static void wednesday(int milk, ArrayList<Integer> one, ArrayList<Integer> two)
    {
        for(int i = 0; i < two.size(); i++)
        {
            int x = two.get(i);
            ArrayList oneNew = new ArrayList<Integer>();
            oneNew = (ArrayList)one.clone();
            oneNew.add(x);
            ArrayList twoNew = new ArrayList<Integer>();
            twoNew = (ArrayList)two.clone();
            twoNew.remove(i);
            thursday(milk + x, oneNew, twoNew);
        }
    }
    public static void thursday(int milk, ArrayList<Integer> one, ArrayList<Integer> two)
    {
        for(int i = 0; i < one.size(); i++)
        {
            int x = one.get(i);
            ArrayList twoNew = new ArrayList<Integer>();
            twoNew = (ArrayList)two.clone();
            twoNew.add(x);
            ArrayList oneNew = new ArrayList<Integer>();
            oneNew = (ArrayList)one.clone();
            oneNew.remove(i);
            friday(milk - x, oneNew, twoNew);
        }
    }
    public static void friday(int milk, ArrayList<Integer> one, ArrayList<Integer> two)
    {
        for(int i = 0; i < two.size(); i++) {
            int x = two.get(i);
            poss[milk+x] = 1;
        }
    }
}
