import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class hps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hps.in"));
        PrintWriter pw = new PrintWriter( new BufferedWriter(new FileWriter("hps.out")));

        int N = Integer.parseInt(br.readLine());


        int[][] pairs = new int[N][2];
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            pairs[i][0] = first;
            pairs[i][1] = second;

        }
        char[][] keys = {
                {'h', 'p', 's'},
                {'h', 's', 'p'},
                {'p', 'h', 's'},
                {'p', 's', 'h'},
                {'s', 'h', 'p'},
                {'s', 'p', 'h'},
        };

        int result = 0;
        for(int i = 0; i < 6; i++) {
            int wins = 0;
            //System.out.println(i);
            for (int j = 0; j < N; j++) {
                int first = pairs[j][0];
                int second = pairs[j][1];
//                System.out.println("first: " + first);
//                System.out.println("second: " + second);
//                System.out.println(i);
                char charfirst = keys[i][first - 1];
                char charsecond = keys[i][second - 1];
//                switch (first) {
//                    case 1:
//                        charfirst = keys[i][0];
//                        break;
//                    case 2:
//                        charfirst = keys[i][1];
//                        break;
//                    case 3:
//                        charfirst = keys[i][2];
//
//                }
//                if (first == 1){
//                    charfirst = keys[i][0];
//                }else if(first == 2){
//
//                }

                if (charfirst == 'h' && charsecond == 's'){
                    wins++;
                }else if (charfirst == 'p' && charsecond == 'h'){
                    wins++;
                }else if (charfirst == 's' && charsecond == 'p') {
                    wins++;
                }


            }

            result = Math.max(result, wins);

        }

        pw.println(result);
        pw.close();
        br.close();
    }
}
