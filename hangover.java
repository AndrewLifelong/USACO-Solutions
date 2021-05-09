import java.io.*;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.StringTokenizer;

 class hangover {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("test.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));

//        List<Float> list = new ArrayList<Float>();

//        list.add(i);
//        while (i != 0.00){
//            i=Float.parseFloat(st.nextToken());
//            list.add(i);
//        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        float i = Float.parseFloat(st.nextToken());

        while (i != 0.00) {
            int n = 2;
            int cards = 1;
            double len = 0.5;
            while (len <= i) {
                len+=(1.0/(n+1));
                cards++;
                n++;

            }
            st = new StringTokenizer(br.readLine());
            i = Float.parseFloat(st.nextToken());

            pw.println(cards + " card(s)");

        }
        pw.close();
        br.close();
    }

}
