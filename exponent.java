import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Scanner;

public class exponent {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuffer result = new StringBuffer();

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            BigDecimal base = in.nextBigDecimal();
            int power = in.nextInt();

            BigDecimal result = base.pow(power);
            String str = new String(result.toPlainString());
            int n = 0;
            while(str.charAt(n)=='0'){
                n++;
            }
            int a = str.length()-1;
            while(str.charAt(a)=='0'){
                a--;
            }
            while(str.charAt(a)=='.'){
                a--;
            }

            System.out.println(str.substring(n,a+1));
        }
    }
}
