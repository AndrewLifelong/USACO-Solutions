import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class hangover2 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            float i = Float.parseFloat(st.nextToken());

            StringBuffer result = new StringBuffer();

            while (i != 0.00) {
                int n = 2;
                int cards = 1;
                double len = 0.5;
                while (len <= i) {
                    len+=(1.0/(n+1));
                    cards++;
                    n++;

                }
                st = new StringTokenizer(br.readLine());
                i = Float.parseFloat(st.nextToken());

                result.append(cards + " card(s)\n");

            }
            System.out.println(result.toString());
        }

    }