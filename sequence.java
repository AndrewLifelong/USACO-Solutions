import java.io.*;
import java.util.StringTokenizer;

public class sequence {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("sequence.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sequence.out")));

        int N = Integer.parseInt(br.readLine());
        float[][] coords= new float[N][3];
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            coords[i][0] = Float.parseFloat(st.nextToken());
            coords[i][1] = Float.parseFloat(st.nextToken());
            coords[i][2] = Float.parseFloat(st.nextToken());
        }
        float marlindist = distance(0,0,0, coords[0][0],coords[0][1],coords[0][2])
                // Marlin distance method goes through the points one by one in the  inputorder.
                ;
        for (int i = 0; i < (N-1); i++){
           marlindist += distance(coords[i][0],coords[i][1],coords[i][2],coords[i+1][0],coords[i+1][1],coords[i+1][2]);
        }
        int marlindist1 = Math.round(marlindist);
        //System.out.println(marlindist1);

        // Best method, starting from the origin point, we use the next point that has the closest distance
        float bestdist = 0;
        float tempdist;
        float rounddist;
        int round_index;
        int[] flags = new int[N];
        float currX = 0, currY = 0, currZ = 0;
        for (int i = 0; i < N; i++) {
            System.out.println("i="+i);
            // find the closest point from the remaining points
            tempdist = 0;
            rounddist = 0;
            round_index = 0;
            for (int j = 0; j < N; j++) {
                System.out.println("j="+j);
                if (flags[j] != 1) {
                    tempdist = distance(currX, currY, currZ, coords[j][0], coords[j][1], coords[j][2]);
                    System.out.println("tempdist = "+tempdist);
                } else {
                    continue; // This point has already been picked before, so we skip it.
                }
                if (rounddist == 0) {
                    rounddist = tempdist;
                } else if (tempdist < rounddist) {
                    rounddist = tempdist;
                    round_index = j;
                }
            }
            // the point with index j is the closest point to the current point,
            // updates current point to the point of round index
            currX = coords[round_index][0];
            currY = coords[round_index][1];
            currZ = coords[round_index][2];

            flags[round_index] = 1;
            bestdist += rounddist;
            System.out.println("roundindex = " + round_index);
            System.out.println("rounddist = " + rounddist);
            System.out.println("best = " + bestdist);


        }
        int bestdist1 = Math.round(bestdist);
        pw.println(marlindist1 + " " + bestdist1);
        pw.close();
        br.close();
    }

    public static float distance(float x1, float y1, float z1, float x2, float y2, float z2){
        double xyz = ((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1))+((z2-z1)*(z2-z1));
        double resultd = Math.sqrt(xyz);
        float result = (float)resultd;
        return result;

    }
}
