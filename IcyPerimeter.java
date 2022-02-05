//   10/11 cases
//   11th case times out
//       Due to the fact I am using java
//       Logic itself is correct
//   http://www.usaco.org/index.php?page=viewproblem2&cpid=895

import java.io.IOException;
import java.util.Arrays;
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


//.print()
//.close()

public class IcyPerimeter {
	
	public static char[][] arr;
	public static int n;
	
	public static int area = 0;
	public static int per = 0;
	
	public static int[][] dir = {
			{1, 0}, {0, 1}, {-1, 0}, {0, -1}
	};
	
	public static void main(String[] args) throws IOException {
		
		Kattio in = new Kattio("perimeter");
		n = in.nextInt();
		
		arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.next().toCharArray();
        }
		//System.out.println(Arrays.deepToString(arr));
		
        
        int maxArea = Integer.MIN_VALUE;
        int minPer = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				
				if (arr[i][j] == '#') {
					dfs(i, j);
					
//					System.out.println();
//					System.out.println(maxArea + " vs " + area);
//					System.out.println(minPer + " vs " + per);
					
					if (maxArea == area) minPer = Math.min(minPer, per);
					else if (maxArea < area) minPer = per;
					
					maxArea = Math.max(maxArea, area);
					
//					System.out.println("---VV---");
//					System.out.println(maxArea + " " + minPer);
//					System.out.println("---^^---");
					
					area = 0;
					per = 0;
				}
				
			}
		}
		
		in.println(maxArea + " " + minPer);
		in.close();
	}

	
	public static void dfs(int r, int c) {
		arr[r][c] = 'v';
		area++;
		
		for (int[] i : dir) {
			int tR = r + i[0];
			int tC = c + i[1];
			
			if (tR < 0 || tR >= n || tC < 0 || tC >= n || arr[tR][tC] == '.') {
				per++;
			}
			else if (arr[tR][tC] == '#') dfs(tR, tC);
			
		}
		
	}
	
}
