import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class FastReader extends PrintWriter{
	private BufferedReader br;
	private StringTokenizer st;
 
	public FastReader() { this(System.in, System.out); }
	public FastReader(InputStream i, OutputStream o) {
		super(o);
		br = new BufferedReader(new InputStreamReader(i));
	}
 
	public String next() {
		try {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		} catch (Exception e) { }
		return null;
	}
 
	public int nextInt() {
        return Integer.parseInt(next());
    }
 
	public long nextLong() {
        return Long.parseLong(next());
    }
 
	public double nextDouble() {
        return Double.parseDouble(next());
    }
 
    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}