import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// basic test cases
// 1 2 3 4 5 6 --> 16
// 100 0 3 2 1 1 --> 7
// 100 23 3 2 1 1 --> 9
// 0 23 5 3 2 1 --> 9
// 100 50 5 4 2 1 --> 14
// 100 50 6 4 3 1 --> 15
// 60 50 40 30 20 10-->70
// 50 80 40 20 10 5 --> 45
// 1000 500 21 5 2 1 --> 94
// 96 19 3 4 1 1 --> 9

/*
1 2 3 4 5 6
100 0 3 2 1 1
100 23 3 2 1 1
0 23 5 3 2 1
100 50 5 4 2 1
100 50 6 4 3 1
60 50 40 30 20 10
50 80 40 20 10 5
1000 500 21 5 2 1
96 19 3 4 1 1
0 0 0 0 0 0
 */

/* Extended test data and answers
0 0 4 0 0 1
7 5 1 0 0 0
36 9 4 1 1 1
0 9 4 1 1 0
0 0 4 0 0 0
36 0 0 0 0 0
0 9 0 0 0 0
79 96 94 30 18 14
53 17 12 98 76 54
83 44 47 42 80 3
15 26 13 29 42 40
41 61 36 90 54 66
78 56 445 45 23 65
13 4 8 29 45 3
15 75 45 98 34 53
40 9 0 2 0 0
41 9 0 2 0 0
44 0 0 0 4 0
0 2 3 0 0 0
37 7 2 0 1 0
12 2 0 1 0 0
13 2 0 1 0 0
0 0 0 0 0 0

data.out
2
1
6
4
1
1
1
86
231
137
115
219
245
79
197
3
4
4
2
3
1
2
 */

public class packets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //StringBuffer result = new StringBuffer();
        int[] packets = new int[6];
        int sum = 0;
        int total = 0;
        for (int i = 0; i < 6; i++){
            packets[i] = Integer.parseInt(st.nextToken());
            sum += packets[i];

        }
        int remaining;
        boolean debug = false;

        while (sum != 0){

            // process 6x6 packets
            total+=packets[5];
            if (debug)
                System.out.println("\n6x6: "+total+" uno: "+packets[0]);

            // process 5x5 packets
            total+=packets[4];
            remaining = 11*packets[4];
            if (packets[0] != 0){
                packets[0] -= remaining; // fill in remaining space with 1x1s
                if (packets[0] < 0){
                    packets[0] = 0;
                }
            }

            if (debug)
                System.out.println("\n5x5"+total+" uno: "+packets[0]);

            // process 4x4 packets
            total+=packets[3];
            remaining = 5*packets[3];
            if (packets[1] != 0) {
                // some 2x2 left
                packets[1] -= remaining; // fill in remaining space with 2x2s
                if (packets[1] < 0) {
                    // no enough 2x2 packets, fill in remaining space with 1x1s
                    if (packets[0] > 0){
                        packets[0] += packets[1] * 4;
                         if (packets[0] < 0){
                             packets[0]=0;
                         }
                    }
                    packets[1] = 0;
                }
            } else {
                // no 2x2 left, fill in 1x1
                if (packets[0] > 0) {
                    packets[0] -= remaining * 4;
                }
            }

            if (debug)
                System.out.println("\n After 4 5 6 processes: " + total+" uno: "+packets[0]);

            // process 3x3 packets, note a 6x6 can hold four 3x3s, so we can
            // have remaining one to three 3x3 space left.
            total+=packets[2]/4;
            remaining = packets[2]%4;

            if (debug)
                System.out.println("\n After 3456 total:  " + total + " remaining: "+ remaining);
            switch (remaining) {
                case 1:
                    // One 3x3 left, need one more 6x6, and 36-9=27 unit spaces
                    // So best fit case is five 2x2 and seven 1x1
                    if (packets[1] != 0) {
                        // some 2x2 left
                        packets[1] -= 5;
                        if (packets[1]<0) {
                            // no enough 2x2 packets, fill in remaining space with 1x1s
                            packets[0] -= packets[1] * 4;
                            packets[1] = 0;
                        }
                        // check if any 1x1 left
                        if (packets[0] > 0){
                            packets[0] -= 7;
                        }
                    } else {
                        // no 2x2 left, fill in 1x1
                        if (packets[0] > 0) {
                            packets[0] -= 27;
                        }
                    }

                    total++;
                    break;

                case 2:
                    // Two 3x3 left,  need one more 6x6, and 36-18=18 unit space
                    // So best fit case is three 2x2 and six 1x1
                    if(packets[1] != 0) {
                        // some 2x2 left
                        packets[1] -= 3;
                        if (packets[1]<0){
                            packets[0] -= packets[1] * 4;
                            packets[1] = 0;
                        }
                        // check if any 1x1 left
                        if (packets[0] > 0){
                            packets[0] -= 6;
                        }
                    } else {
                        // no 2x2 left, fill in 1x1
                        if (packets[0] > 0) {
                            packets[0] -= 18;
                        }
                    }

                    total++;
                    break;

                case 3:
                    // Three 3x3 left,  need one more 6x6, and 36-27 = 9 unit space
                    // So best fit case is one 2x2 and 5 1x1
                    if(packets[1] != 0) {
                        // some 2x2 left
                        packets[1] -= 1;
                        if (packets[1]<0){
                            packets[0] -= packets[1]*4;
                            packets[1] = 0;
                        }
                        // check if any 1x1 left
                        if (packets[0] > 0){
                            packets[0] -= 5;
                        }
                    } else {
                        // no 2x2 left, just check 1x1
                        if (packets[0] > 0) {
                            packets[0] -= 9;
                        }
                    }

                    total++;
                    break;

                default:
                    break;
            }

            if (debug)
                System.out.println("\n 3x3 "+total+"uno left: "+packets[0]+" 2x2 left: "+packets[1]);

            // process 2x2
            total+=packets[1]/9;

            remaining = packets[1]%9;
            if (remaining != 0){
                packets[0] -= 36-remaining*4;
                total++;
            }
            if (debug)
                System.out.println("2x2: "+total);

            // process uno x uno
            if (packets[0] > 0){
                total += packets[0]/36;
                if (packets[0]%36 != 0){
                    total++;
                }
            }
            if (debug)
                System.out.println("1x1 "+total);

            //result.append(total+"\n");
            System.out.println(total);

            // read next line
            sum = 0;
            total = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                packets[i] = Integer.parseInt(st.nextToken());
                sum += packets[i];
            }
        }
        //System.out.println(result.toString());
    }
}
