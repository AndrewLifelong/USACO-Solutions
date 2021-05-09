import java.io.*;
import java.util.StringTokenizer;

public class billboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x5 = Integer.parseInt(st.nextToken());
        int y5 = Integer.parseInt(st.nextToken());
        int x6 = Integer.parseInt(st.nextToken());
        int y6 = Integer.parseInt(st.nextToken());
        int totalArea = visible_Area(x1,y1,x2,y2,x5,y5,x6,y6)+visible_Area(x3,y3,x4,y4,x5,y5,x6,y6);
        pw.println(totalArea);
        pw.close();
        br.close();
    }
    public static int areaOfRect(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) * Math.abs(y2 - y1);
    }
    public static int visible_Area(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int area = areaOfRect(x1,y1,x2,y2);
        int leftmostblocked = Math.max(x1,x3);
        int rightmostblocked = Math.min(x2,x4);
        int bottommostblocked = Math.max(y1,y3);
        int topmostblocked = Math.min(y2,y4);
            System.out.println(topmostblocked);
        if((leftmostblocked < rightmostblocked) && (bottommostblocked < topmostblocked)) {
            area -= areaOfRect(leftmostblocked, bottommostblocked, rightmostblocked, topmostblocked);
            System.out.println(area);
        }
        return area;
    }
}
