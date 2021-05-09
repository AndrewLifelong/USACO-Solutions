import java.io.*;
        import java.util.*;

public class lineup {
    public static int c = 0;
    public static String[] min = {"Sue","Sue","Sue","Sue","Sue","Sue","Sue","Sue"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));

        int N = Integer.parseInt(br.readLine());
        String[] bogas = {"Bessie","Buttercup","Belinda","Beatrice","Bella","Blue","Betsy","Sue",};
        Arrays.sort(bogas);
        String[][] bass = new String[N][2];
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String boga1 = st.nextToken();
            bass[i][0] = boga1;
            st.nextToken();
            st.nextToken();
            st.nextToken();
            st.nextToken();
            String boga2 = st.nextToken();
            bass[i][1] = boga2;
        }
        gen(bogas,8,bass);
        for (int i = 0; i < bogas.length;i++){
            pw.println(min[i]);
        }
        pw.close();
        br.close();

    }

    public static void gen(String[] arr, int k,String[][] a){
        if (k == 1){
            if (check(arr,a)){
                return;
            }
        }else{
            gen(arr,k-1,a);
            for (int i = 0; i < k-1;i++){
                if(k%2 == 0){
                    swap(arr,i,k-1);
                }else{
                    swap(arr,0,k-1);
                }
                gen(arr,k-1,a);
            }
        }
    }
    static boolean check(String[]arr, String[][] boga){
        int boga1index = 0;
        int boga2index = 0;
        for (int i = 0; i < boga.length;i++){
            boga1index = indexOf(arr,boga[i][0]);
            boga2index = indexOf(arr,boga[i][1]);
            if (Math.abs(boga1index-boga2index)!=1){
                return false;
            }
        }
        // compare current array with minimum, save new minimum if so
        for (int i = 0; i < arr.length; i++) {
            int compare = arr[i].compareTo(min[i]);
            if (compare > 0) {
                // this is alphabetically bigger, skip it
                break;
            } else if (compare == 0) {
                // compare next string in the array
                continue;
            } else {
                // find a new minimum, save the copy!
                min = Arrays.copyOf(arr, arr.length);
//                for (int j = 0; j < min.length;j++){
//                    System.out.print(min[j]+" ");
//                }
//                System.out.println("");
            }
        }
        return true;
    }
    static void swap(String[] arr, int i, int k){
        String temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
    }
    static int indexOf(String[]arr, String str){
        for (int i = 0; i < arr.length;i++){
            if (arr[i].equals(str)){
                return i;
            }
        }
        return -1;
    }
}
