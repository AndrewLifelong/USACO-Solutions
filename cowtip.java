import java.io.*;

public class cowtip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
        int N = Integer.parseInt(br.readLine());
        char[][] grid = new char[N][N];

        final char tipped = '1';
        final char standing = '0';

        for (int i = 0; i < N; i++){
            String field = br.readLine();
            for (int j = 0; j < N;j++){
                grid[i][j] = field.charAt(j);
                // reads in the grid, using 2 loops with both N as a dimension.
            }


        }

        int tippedover = 0;

        for (int i = N-1; i >= 0; i--){
            for (int j = N-1; j >= 0; j--){
                if (grid[i][j] == tipped){
                    tippedover++;
                    // Do less than or equals to, not equal to because has to iterate through ALL blocks.
                    for(int a = 0; a <= i; a++){
                        for(int b = 0; b <= j; b++){
                            if (grid[a][b] == tipped){
                                grid[a][b] = standing;

                            }else{
                                grid[a][b] = tipped;
                            }
                        }

                    }
                }
            }
        }
        pw.println(tippedover);
        pw.close();
        br.close();

    }
}
