import java.io.IOException;
import java.io.*;
import java.util.*;

public class perimeter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("test.in"));
        // Read in values for coordinates, put in 2d array using StringTokenizer
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ";");
            for (int j = 0; j < 2; j++) {
                points[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        // Find all possible combinations of 3 sets of coordinates to check
        // whether they form a right triangle - if yes, count perimeter

        double sum = 0;
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
                        sum += perimeter(x1,y1,x2,y2,x3,y3);
                    }
                }
            }
        }
        System.out.println(Math.round(sum));
    }
    // This method takes in the coordinates for 3 points(6 total), calculates whether they form a right triangle
    // w/ legs that are parallel to x and y axis
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

    // Method finds the perimeter given 3 point's coordinates
    public static double perimeter(int x1, int y1, int x2, int y2, int x3, int y3){
        double total = 0;
        total += Math.sqrt((((x2-x1)*((x2-x1))+(((y2-y1)*(y2-y1))))));
        total += Math.sqrt((((x3-x1)*((x3-x1))+(((y3-y1)*(y3-y1))))));
        total += Math.sqrt((((x3-x2)*((x3-x2))+(((y3-y2)*(y3-y2))))));
        return total;
    }
    // Additional Test cases that I tried
    ////        System.out.println(formsRightTri(1,1,2,2,3,3)); f
    ////        System.out.println(formsRightTri(1,1,3,3,1,3)); t
    ////        System.out.println(formsRightTri(1,1,2,2,1,3)); f
    ////        System.out.println(formsRightTri(3,3,1,3,1,1)); t
    ////        System.out.println(formsRightTri(0,0,0,3,-3,0));t
    ////        System.out.println(formsRightTri(0,3,0,0,-3,0));t
    ////        System.out.println(formsRightTri(1,1,2,2,3,1)); f
    ////        System.out.println(formsRightTri(1,1,3,1,3,3)); t
    ////        System.out.println(formsRightTri(-3,0,0,0,3,0));f


}
