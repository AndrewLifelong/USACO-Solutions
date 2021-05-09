import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sleepy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = N-1;
        for (int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N-2; i>-1;i--){
            if (nums[i] < nums[i+1]){
                count = i;
            }else{
                break;
            }
        }
        pw.println(count);
        pw.close();
        br.close();
    }
}
