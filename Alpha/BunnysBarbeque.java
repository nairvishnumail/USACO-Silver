import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BunnysBarbeque {
	
	public static int n;
	public static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		n = in.nextInt();
		int[][] r = new int[n+1][2];
		
		// input
		for (int i = 1; i <= n; i++) {
			r[i][1] = in.nextInt();
			
			if (in.next().equals("S")) r[i][0] = 1;
			else r[i][0] = -1;
		}
		
		// sort
		Arrays.sort(r, (a,b) -> Integer.compare(a[1], b[1]));
		
		// print
//		System.out.print("\n [");
//		for (int[]i : r) {
//			if (i[0] == 1) System.out.print("S, ");
//			else if (i[0] == 0) System.out.print("0, ");
//			else System.out.print("N, ");
//		}
//		System.out.println("]");
//		System.out.print("\n[");
//		for (int[]i : r) {
//			System.out.print(i[0] + ", ");
//		}
//		System.out.println("]\n");
		
		
		int output = Integer.MIN_VALUE;
		// checking if same
		int preVal = 0;
		int preInd = 0;
		for (int i = 0; i <= n; i++) {
			//System.out.print(r[i][1] + " ");
			if (preVal == r[i][0]) {
				output = Math.max(output, r[i][1]-preInd);
				//System.out.print(r[i][1]-preInd);
			}
			else {
				preVal = r[i][0];
				preInd = r[i][1];
				//System.out.print("setting val " + preVal + " & ind " + preInd);
			}
			//System.out.println();
		}
		
		
		
		
		
		// prefix
		for (int i = 1; i <= n; i++) {
			r[i][0] += r[i-1][0];
		}
		
		// print
//		System.out.print("\n [");
//		for (int[]i : r) {
//			System.out.print(i[0] + ", ");
//		}
//		System.out.println("]");
//		System.out.print(" [");
//		for (int[]i : r) {
//			System.out.print(i[1] + ", ");
//		}
//		System.out.println("]\n");
		
		// driver
		Map<Integer, Integer> m = new HashMap<>();
		
		
		for (int i = 0; i <= n; i++) {
			//System.out.print(r[i][1] + " ");
			if (m.containsKey(r[i][0])) { // already has a min value
				output = Math.max(output, (r[i][1] - r[m.get(r[i][0])+1][1]));
				//System.out.print((r[i][1] - r[m.get(r[i][0])+1][1]));
			}
			else {
				m.put(r[i][0], i);
				//System.out.print("putting " + i);
			}
			//System.out.println();
		}
		
		System.out.println(output);
	}

}
