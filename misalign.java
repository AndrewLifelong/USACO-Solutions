import java.io.*;
import java.util.StringTokenizer;

public class misalign {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("misalign.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("misalign.out")));
            StringTokenizer st = new StringTokenizer(br.readLine());
            // We first read in the x,y, and z values separated by spaces, so we use StringTokenizer
            float x = Float.parseFloat(st.nextToken());
            float y = Float.parseFloat(st.nextToken());
            float z = Float.parseFloat(st.nextToken());
            // We read in the velocites
            float vx = Float.parseFloat(st.nextToken());
            float vz = Float.parseFloat(st.nextToken());
            // We create variables for the angles, calculated by taking two lengths of a triangle
            // created by corresponding x and y values and take the inverse tan.
            double yawchange = Math.atan(y/x);
            double pitchchange = Math.atan(z/x);
            // Since java converts the angle to radians, we must convert them to degrees
            yawchange = Math.toDegrees(yawchange);
            pitchchange = Math.toDegrees(pitchchange);
            // The time is equal to the time it takes to move across each axis with a given velocity, so we can just divide
            // the distance with the velocity as D = rt.
            double time = x/vx;
            time = Math.round(time);
            // We convert them to floats to round them
            float yawangle = (float)yawchange;
            float pitchangle = (float)pitchchange;
            float time2 = (float)time;
            int time3 = Math.round(time2);
            int yawangle1 = Math.round(yawangle);
            int pitchangle2 = Math.round(pitchangle);
            // Since the upper z axis will always be negative, we multiply the value by -1.
            pitchangle2 = pitchangle2*(-1);

            pw.println(yawangle1+ " " + pitchangle2 + " " + time3);
            pw.close();
            br.close();

    }
}
