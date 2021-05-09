import java.io.*;
import java.util.*;

class blocks{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
        int[] ret = new int[26];
        Arrays.fill(ret,0);
        int N = Integer.parseInt(br.readLine());
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String side1 = st.nextToken();
            String side2 = st.nextToken();
            int[] ret1 = new int[26];
            for(int j= 0; j < side1.length(); j++) {
                int index = indexOf(alphabet,side1.substring(j,j+1));
                ret1[index]++;
            }
            int[] ret2 = new int[26];
            for(int j= 0; j < side2.length(); j++) {
                int index = indexOf(alphabet,side2.substring(j,j+1));
                ret2[index]++;
            }
            for (int j = 0; j < 26; j++) {
                if (ret1[j] > ret2[j]) {
                    ret[j] += ret1[j];
                } else {
                    ret[j] += ret2[j];
                }
            }
        }
        for(int i = 0; i < 26; i++) {
            pw.println(ret[i]);
        }

        pw.close();
        br.close();


    }
    public static int indexOf(String[] arr, String boga){
        for (int i = 0; i < arr.length;i++){
            if (arr[i].equals(boga)){
                return i;
            }
        }
        return -1;
    }
}