import java.io.*;
import java.util.StringTokenizer;

public class breedflip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("test.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        int N = Integer.parseInt(br.readLine());
        String A = br.readLine();
        String B = br.readLine();
        boolean lasttransfer = false;
        int breedflips = 0;
        String[] achars = new String[N + 1];
        String[] bchars = new String[N + 1];
        for (int i = 0; i < N; i++) {
            achars[i] = A.substring(i, i + 1);
        }
        for (int i = 0; i < N; i++) {
            bchars[i] = B.substring(i, i + 1);
        }
        for (int i = 0; i < N; i++) {
            if (!bchars[i].equals(achars[i])){
                if (lasttransfer == false) {
                    breedflips++;
                    // need transfer, last time didn't transfer
                    lasttransfer = true;
                }
            }else{
                System.out.println("euqual");
                lasttransfer = false;

            }
            System.out.println(bchars[i] + " " + achars[i]);
            System.out.print(lasttransfer);
            System.out.println(" " + breedflips);


        }
        System.out.println(breedflips + "aaa");
        pw.println(breedflips + "bbb");
        pw.close();
        br.close();
    }
}



