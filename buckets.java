import java.io.*;

public class buckets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
        String[] boga = new String[10];
        int bx = 0, by = 0, rx = 0,ry = 0,lx = 0,ly = 0;
        for (int i = 0; i < 10;i++){
            boga[i] = br.readLine();
        }
        int min = 0;
        for (int i = 1; i <= 10;i++){
            for (int j = 1; j <= 10; j++){
                String bogason = boga[i-1].substring(j-1,j);
                if(bogason.equals("B")){
                    bx = j;
                    by = i;
                }else if (bogason.equals("R")){
                    rx = j;
                    ry = i;
                }else if (bogason.equals("L")){
                    lx = j;
                    ly = i;
                }
            }
        }
        if (bx == lx){
            if (rx == bx && (ry>by && ry<ly) || (ry<by && ry>ly)){
                min = Math.abs(ly-by)+1;
            }else{
                min = Math.abs(ly-by)-1;
            }
        }else if (by == ly){
            if ((rx>bx && rx<lx) || (rx<bx && rx>lx)){
                min = Math.abs(lx-bx)+1;
            }else {
                min = Math.abs(lx - bx)-1;
            }
        }else{
            min = Math.abs(lx-bx) + Math.abs(ly-by)-1;
        }
        pw.println(min);
        pw.close();
        br.close();
    }
}
