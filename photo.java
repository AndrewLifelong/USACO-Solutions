import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class photo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("photo.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
        int N = Integer.parseInt(br.readLine());
        int[] b = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1;i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        int[] a = new int[N];
        for (int i = 1; i < b[0];i++){
            int j;
            // Create set to check repeating frequencies
            Set<Integer> nums = new HashSet<Integer>();
            // Create variable to hold variations for b[0]-i
            int nub = i;
            nums.add(nub);
            a[0] = nub;
            for (j = 0; j < N-1;j++){
                int nub2 = b[j]-nub;
                if ((nums.contains(nub2) || nub2 <= 0)){
                    Arrays.fill(a,0);
                    break;
                    // We break if there is a repetition in occurrences as the cow's ids are unique
                }else{
                    a[j+1] = nub2;
                    nub = nub2;
                    nums.add(nub2);
                    // If nothing is repetitive we simply increment nub to fit the difference between the next value
                }
            }
            if (j == N-1){
                break;
            }

        }
        for (int i = 0; i < N-1;i++){
            pw.print(a[i]+" ");
            // Print out a
        }
        pw.println(a[N-1]);
        pw.close();
        br.close();



    }
}
