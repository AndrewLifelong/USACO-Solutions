import java.io.*;
import java.lang.reflect.Array;
import java.util.StringTokenizer;
import java.util.*;
public class swap {
    public static int N;
    public static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("swap.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int A1 = Integer.parseInt(st.nextToken());
        int A2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int B1 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        for(int i = 0; i < N; i++) nums[i] = i;
        int cycleSize = 0;
        boolean sorted = true;
        do {
            cycleSize++;
            swap(nums, A1, A2);
            swap(nums, B1, B2);
            sorted = true;
            for(int i = 0; sorted && i < N; i++) sorted = nums[i] == i;
        }
        while(!sorted);
        K %= cycleSize;
        for(int i = 0; i < N; i++) nums[i] = i+1;
        for(int i = 0; i < K; i++) {
            swap(nums, A1, A2);
            swap(nums, B1, B2);
        }
//        System.out.println(nums);

        for (int i = 0; i < nums.length;i++){
            pw.println(nums[i]);
        }
        pw.close();
        br.close();
    }
    public static int[] swap(int[] nums, int one, int two){
        ArrayList<Integer> A = new ArrayList<Integer>();
        for (int j = one - 1; j < two; j++) {
            A.add(nums[j]);
        }
        Collections.reverse(A);
        int increment1 = 0;
        for (int j = one - 1; j < two; j++) {
            nums[j] =  A.get(increment1);
            increment1++;
        }
        return nums;
    }
}
