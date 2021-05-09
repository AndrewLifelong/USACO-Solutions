import java.io.*;
import java.util.*;

public class reduce {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N];
        int[] y = new int[N];
        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        int maxy = Integer.MIN_VALUE;
        for (int i = 0; i < N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            if (x[i]>maxx){
                maxx = x[i];
            }
            if (x[i]<minx){
                minx = x[i];
            }
            y[i] = Integer.parseInt(st.nextToken());
            if (y[i]>maxy){
                maxy= y[i];
            }
            if (y[i]<miny){
                miny = y[i];
            }
        }
        boolean[] onBorder = new boolean[N];
        for (int i = 0; i < N;i++){
            if ((x[i] == minx || x[i] == maxx) || (y[i]==miny)||(y[i]==maxy)){
                onBorder[i] = true;
            }else{
                onBorder[i] = false;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0;i < N;i++){
            if (onBorder[i]){
                if (getArea(x,y,i)<min){
                    min = getArea(x,y,i);
                }
            }
        }
        pw.println(min);
        pw.close();
        br.close();
    }
    public static int getArea(int[] x,int[] y, int skip){
        int area = 0;
        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE;
        int maxy = Integer.MIN_VALUE;
        for (int i = 0; i < x.length;i++){
            if (i == skip){
                continue;
            }
            if (x[i]>maxx){
                maxx = x[i];
            }
            if (x[i]<minx){
                minx = x[i];
            }
            if (y[i]>maxy){
                maxy= y[i];
            }
            if (y[i]<miny){
                miny = y[i];
            }
        }
        return((maxx-minx)*(maxy-miny));
    }

}
