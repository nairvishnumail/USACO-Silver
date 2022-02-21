import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class cownomics2 {

    public static void main(String[] args) throws  IOException{
        Vishnu in  = new Vishnu();
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] gene = new char[n*2][m];

        int count = 0;
        int r = 0;

        for (int i = 0; i < n*2; i++) {
            gene[i] = in.next().toCharArray();
        }

        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                for (int k = j+1; k < m; k++) {
                    count += check(i, j, k, gene, n);
                }
            }
        }
        
        in.println(count);
        in.close();

    }

    private static int check(int i, int j, int k, char[][] gene, int n) {
        int count = 0;
        HashSet<String> hs = new HashSet<>();
        for (int c = 0; c < n; c++) {
            String s = "" + gene[c][i] + gene[c][j] + gene[c][k];
            hs.add(s);
        }
        for (int p = n; p < n*2; p++) {
            String s = "" + gene[p][i] + gene[p][j] + gene[p][k];
           if(hs.contains(s)) return 0;
        }
        return 1;
    }

    static class Vishnu extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Vishnu () { this(System.in, System.out); }
        public Vishnu (InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
        public Vishnu (String problemName) throws IOException {
            super(new FileWriter(problemName + ".out"));
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }

        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }

}
