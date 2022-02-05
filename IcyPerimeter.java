//   10/11 cases
//   11th case times out
//       Due to the fact I am using java
//       Logic itself is correct
//   http://www.usaco.org/index.php?page=viewproblem2&cpid=895

import java.util.Arrays;

public class IcyPerimeter {
	
	public static char[][] arr;
	public static int n;
	
	public static int area = 0;
	public static int per = 0;
	
	public static int[][] dir = {
			{1, 0}, {0, 1}, {-1, 0}, {0, -1}
	};
	
	public static void main(String[] args) throws IOException {
		
		Kattio in = new Kattio(); // if using file input --> new Kattio("perimeter)  && add Kattio code to file
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
