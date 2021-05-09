import java.io.*;
import java.util.StringTokenizer;

public class square {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        // Uses rectangle values to read in variables for first rectangle
        // Creates rectangle
        Rect rect1 = new Rect(x1, y1, x2, y2);
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        // Second rectangle
        Rect rect2 = new Rect(x1, y1, x2, y2);
        // To obtain the length and width of the big rectangle, which will become a square, we need to find the longer dimension.
        // Hence we need to subtract the right most x value with the left to find the length of the length, and subtract the top from bottom to
        // find the length of the width.
        int leftBound = Math.min(rect1.x1, rect2.x1);
        // Leftmost x-value
        int rightBound = Math.max(rect1.x2, rect2.x2);
        // rightmost x-value
        int topBound = Math.max(rect1.y2, rect2.y2);
        // topmost Y-value
        int bottomBound = Math.min(rect1.y1, rect2.y1);
        // bottomMost y - value

        int length = rightBound - leftBound;
        int width = topBound - bottomBound;

        int sideLength = Math.max(length, width);
        // Compares to see which one is larger
        int area = sideLength * sideLength;
        // Calculates square area.

        pw.println(area);
        pw.close();
        br.close();
    }
}

class Rect{
    // Class to hold rectangle corner coordinates
    public int x1, y1, x2, y2;

    public Rect(int x1, int y1, int x2, int y2) {
        // Turns coordinates into variables, uses variables to determine length and width.
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}