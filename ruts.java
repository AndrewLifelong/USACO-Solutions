import java.util.*;

public class ruts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[][] cows = new int[N][2];
        TreeMap<Integer,Integer> East = new TreeMap<Integer,Integer>();
        TreeMap<Integer,Integer> North = new TreeMap<Integer,Integer>();
        for (int i = 0; i < N; i++){
            char c = scanner.next().charAt(0);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            cows[i][0] = x;
            cows[i][1] = y;
            if (c=='E'){
                East.put(y,i);// East map sorts by y value
            }
            if (c=='N'){
                North.put(x,i);// North map sorts by x value
            }
        }
        System.out.println(North);
        System.out.println(East);
        int ekey = 0;
        int nkey = 0;
        int[] stopPoints = new int[N];
        Arrays.fill(stopPoints,0);
        int result = 0;
        int northsize = North.size();
        int temp = North.size();
        while(East.size()!=0){
            // Get front elements of East map
            ekey = East.firstKey();
            nkey = North.firstKey();
            int nc = North.get(nkey);
            int ec = East.get(ekey);
//            System.out.println(ec);
//            System.out.println(nc);
            for (int i = 0; i < northsize;i++){
                result = willCollide(cows[ec][0],cows[ec][1],cows[nc][0],cows[nc][1]);
                System.out.println("result: " + result + " ec :" + ec  + " nc :" + nc);
                if (result == 1){
                    // North stops, record stopping point in array, remove element from treemap
                    stopPoints[nc] = cows[ec][1]-cows[nc][1];
                    North.remove(nkey);
                    if(i != northsize-1){
                        nkey = North.higherKey(nkey);
                        nc = North.get(nkey);
                    }
                }else if (result == 2){
                    // East stops, record stopping point in array, remove element from treemap
                    stopPoints[ec] = cows[nc][0]-cows[ec][0];
                    East.remove(ekey);
                    break;
                }else{
                    // return 0, no collision --> find next
                    East.remove(ekey);
                    if(i != northsize-1){
                        nkey = North.higherKey(nkey);
                        nc = North.get(nkey);
                    }
                }
//                System.out.println(East);
            }
            northsize = North.size();
//            System.out.println("gae size " + northsize);

            if (North.size() == 0 || East.size() == 0){
                break;
            }
            System.out.println(North);
            System.out.println(East);
        }
        for (int i = 0; i < stopPoints.length;i++){
            if (stopPoints[i] != 0){
                System.out.println(stopPoints[i]);
            }else{
                System.out.println("Infinity");
            }
        }
    }
    // Checks whether two vectors will collide, return either 1,2,0
    // 0 --> no collision
    // 1 --> north stops
    // 2 --> east stops
    public static int willCollide(int x1, int y1, int x2, int y2){

        if (y2<y1 && x2>x1){
            if ((y1-y2)>(x2-x1)){
                return 1;
            }
            if ((y1-y2)<(x2-x1)){
                return 2;
            }
        }
        return 0;
    }

}
