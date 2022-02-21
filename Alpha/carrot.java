import java.io.*;
import java.util.*;


public class carrot {

    static class dist implements Comparable<dist>{
        private int d;
        private int s;
        private int f;

        public dist(int d, int s, int f) {
            this.d = d;
            this.s = s;
            this.f = f;
        }

        @Override
        public String toString() {
            return "dist{" +
                    "d=" + d +
                    ", s=" + s +
                    ", f=" + f +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public int compareTo(dist o) {
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        Kattio in = new Kattio ();
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        dist[] d = new dist[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }
        Arrays.sort(c);
        int j = 0;
        int x = 0;
        for (int i = 0; i < n; i++) {
            while (j<n && c[j] - c[i] <= k) j++;
            j--;
            d[i] = new dist(j-i+1, c[i], c[j]);
            x++;
        }

        int[] bps = new int[n];
        bps[n-1] = d[n-1].d;
        for (int i = n-2; i >= 0; i--) {
            bps[i] = Math.max(d[i].d, bps[i+1]);
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(d[i]+ " : " + bps[i]);
//        }
        int mc = Integer.MIN_VALUE;
        int wywci = 1;
        for (int i = 0; i < n-1; i++) {
            while(d[wywci].s <d[i].f) wywci++;
            mc = Math.max(mc, d[i].d + bps[wywci]);
        }
        mc = Math.max(mc, d[n-1].d);
        in.println(mc);
        in.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio () {
            this(System.in, System.out);
        }

        public Kattio (InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio (String problemName) throws IOException {
            super(new FileWriter(problemName + ".out"));
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}

