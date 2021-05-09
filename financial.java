import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class financial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer result = new StringBuffer();
        double average = 0.00;
        double sum = 0.00;
        for (int i = 0; i < 12; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            sum += Double.parseDouble(st.nextToken());
        }
        average = sum/12.00;
//        System.out.println(average);
        average = Math.round(average*100)/100.0;
        result.append("$"+average+"\n");


        System.out.println(result);
    }

}