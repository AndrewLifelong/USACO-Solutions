import java.util.Scanner;

public class chains {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] flowers = new int[N];
        for (int i = 0; i < N;i++){
            flowers[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int b = 0;
                double[] sub = new double[j-i+1];
                double sum = 0;
               // System.out.println(i + " " + j);
                for (int a = i; a <= j;a++,b++){
                    sub[b] = flowers[a];
                    sum+=sub[b];
//                    System.out.print(sub[b] + " ");
                }
//                System.out.println("");
                double avg = sum/sub.length;
                for (double flower : sub){
                    if (flower == avg){
                        count++;
                        break;
                    }
                }
//                System.out.println(count);
            }
        }
        // pictures with 1 flower always get counted
        System.out.println(count+N);
    }
}
