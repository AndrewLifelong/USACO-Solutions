import java.io.*;
        import java.util.StringTokenizer;

public class triangles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                points[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++){
            for (int j = i+1; j < N; j++){
                for (int k = j+1; k < N; k++){
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    if (formsRightTri(x1,y1,x2,y2,x3,y3)){
                        int area = findArea(x1,y1,x2,y2,x3,y3);
                        if (area>max){
                            max = area;
                        }
                    }
                }
            }
        }
        pw.println(max);
        pw.close();
        br.close();
    }
    public static boolean formsRightTri(int x1, int y1, int x2, int y2, int x3, int y3){
        if ((x2 == x1)&&(y3 == y1 || y3 == y2)){
            return true;
        }
        if ((x3 == x1)&&(y2 == y1 || y2 == y3)){
            return true;
        }
        if ((x3 == x2)&&(y1 == y2 || y1 == y3)){
            return true;
        }
        return false;
    }
    public static int findArea(int x1, int y1, int x2, int y2, int x3, int y3){
        if ((x2 == x1)&&(y3 == y1 || y3 == y2)){
            return Math.abs(y2-y1)*Math.abs(x3-x1);
        }
        if ((x3 == x1)&&(y2 == y1 || y2 == y3)){
            return Math.abs(y3-y1)*Math.abs(x2-x1);
        }
        if ((x3 == x2)&&(y1 == y2 || y1 == y3)){
            return Math.abs(y3-y2)*Math.abs(x2-x1);
        }
        return 0;
    }
}
