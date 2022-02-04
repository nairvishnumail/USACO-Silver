import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Kattio extends PrintWriter {
	private BufferedReader r;
	private StringTokenizer st;

	// standard input
	public Kattio() { this(System.in, System.out); }
	public Kattio(InputStream i, OutputStream o) {
		super(o);
		r = new BufferedReader(new InputStreamReader(i));
	}
	// USACO-style file input
	public Kattio(String problemName) throws IOException {
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



public class DanceMooves {
	public static void main(String[] args) {
		Kattio in = new Kattio();
		
		int cowNum = in.nextInt();
		int connect = in.nextInt();
		
		int[] cows = new int[cowNum+1];
		ArrayList[] reach = new ArrayList[cowNum+1];
		reach[0] = new ArrayList<Integer>();
		for (int i = 1; i <= cowNum; i++) {
			cows[i] = i;
			reach[i] = new ArrayList<Integer>();
			reach[i].add(i);
		}
		
		
		
		for (int i = 0; i < connect; i++) {
			int first = in.nextInt();
			int second = in.nextInt();
			
			reach[cows[first]].add(second);
			reach[cows[second]].add(first);
			
			int temp = cows[first];
			cows[first] = cows[second];
			cows[second] = temp;
			//System.out.println(Arrays.toString(cows));
		}
		
		
		
//		System.out.println();
//		for (Set i : reach) {
//			System.out.println(i.toString());
//		}
		
		
		int[] ans = new int[cowNum+1];
		for (int i = 1; i <= cowNum; i++) {
			if (cows[i] == 0) {
				continue;
			}
			
			Set x = new HashSet<Integer>();
			x.addAll(reach[i]);
			ArrayList<Integer> connectedCows = new ArrayList<Integer>();
			
			connectedCows.add(i);
			int next = cows[i];
			cows[i] = 0;
			while (cows[next] != 0) {
				//System.out.println(Arrays.toString(cows));
				connectedCows.add(next);
				x.addAll(reach[next]);
				int temp = cows[next];
				cows[next] = 0;
				next = temp;
			}
			//System.out.println(connectedCows.toString());
			for (Integer j : connectedCows) {
				ans[j] = x.size();
			}
		}
		
//		System.out.println();
//		for (Set i : reach) {
//			System.out.println(i.toString());
//		}
		
		for (int i = 1; i <= cowNum; i++) {
			System.out.println(ans[i]);
		}
	}

}
