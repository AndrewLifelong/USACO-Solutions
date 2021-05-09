import java.io.*;
import java.util.StringTokenizer;

public class Image {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("test.in"));
        int N = Integer.parseInt(br.readLine());
        // Create variables to initialize minimum, maximum, difference, array to hold values
        int[][] image = new int[N][N];
        // Read in the input using a 2-d array using StringTokenizer, set delim to ";" as values are
        // separated by semicolons
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(),";");
            for(int j = 0; j < N; j++){
                image[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        int min = image[0][0];
        int max = image[0][0];
        int diff;
        // Calculate maximum and minimum values of all input values, calculate final diff
        for (int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if (image[i][j] > max){
                    max = image[i][j];
                }
                if (image[i][j] < min){
                    min = image[i][j];
                }
            }
        }
        diff = max-min;
        if (diff < 10){
            // If diff is less than 10, we leave the channel alone and output straight away
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (j == N-1){
                        System.out.print(image[i][j]);
                    }else{
                        System.out.print(image[i][j]+";");
                    }
                }
                System.out.println("\n");
            }
        }else{
            // Otherwise, we round 0.1*d and add to any values less than 100
            int patch = (int)(Math.round(0.1*diff));
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (image[i][j] < 100){
                        image[i][j]+=(patch);
                    }
                    // print out answer
                    if (j == N-1){
                        System.out.print(image[i][j]);
                    }else{
                        System.out.print(image[i][j]+";");
                    }
                }
                System.out.print("\n");
            }
        }
    }
}
