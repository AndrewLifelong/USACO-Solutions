public class Lesson4 {
    public static void main(String[] args) {
        System.out.println(factR(4));
        System.out.println(factI(4));

    }
    public static int factR(int n) {
        int result;
        if(n == 1){
            return 1;
        }
        System.out.println(n);
        result = factR(n-1)*n; // If n=2, n-1 or 1 is referenced first
        System.out.println(result);
        return result;
    }

    public static int factI(int n){
        int t;
        int result;

        result = 1;
        for (t=1; t <= n; t++){
            result *= t;
        }
        return result;
    }

}
