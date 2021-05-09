import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class revegetate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] one = new int[151];
        int[] two = new int[151];
        for(int i = 0; i < M;i++){
            st = new StringTokenizer(br.readLine());
            one[i] = Integer.parseInt(st.nextToken());
            two[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M;i++){
            int temp = one[i];
            if (one[i]>two[i]){
                one[i] = two[i];
                two[i] = temp;
            }
        }
        int[] ret = new int[101];
        for (int i = 1; i <= N;i++){
            int g = 0;
            for (g = 1; g <= 4; g++) {
                boolean flag = true;
                for (int j=0; j<M; j++)
                    if (two[j] == i && ret[one[j]] == g){
                        flag = false;
                    }
                if (flag) {
                    break;
                }
            }
            ret[i] = g;
        }
//        int[] ret2 = new int[101]
//        if (ret[0] == 0){
//            for (int i = 1; i < ret.length-1){
//                ret2[i] = ret[i];//            }

//        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N;i++){
            sb.append((ret[i]));
        }
        BigInteger str = new BigInteger(sb.toString());
        pw.println(str);
        pw.close();
        br.close();

    }
}
