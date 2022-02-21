import java.util.Arrays;
import java.util.Scanner;

public class PawEarTail {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] predict = new int[n];
		// ear --> 1
		// paw --> 2
		// tail --> 3
		
		// 2 beats 1
		// 1 beats 3
		// 3 beats 2
		for (int i = 0; i < n; i++) {
			String s = in.next();
			if (s.equals("E")) predict[i] = 1;
			else if (s.equals("P")) predict[i] = 2;
			else predict[i] = 3;
		}
		
		
		int[][] moves = new int[3][n];
		int[][] movesF = new int[3][n];
		int[][] movesB = new int[3][n];
		// first row will be paws (2)
		// second row will be tail (3)
		for (int i = 0; i < n; i++) {
			if (predict[i] == 1) {
				moves[0][i] = 1;
				movesF[0][i] = 1;// paws
				movesB[0][i] = 1;// paws
			}
			else if (predict[i] == 2) {
				moves[1][i] = 1;
				movesF[1][i] = 1;// tail
				movesB[1][i] = 1;// tail
			}
			else {
				moves[1][i] = 1;
				movesF[2][i] = 1; // ear
				movesB[2][i] = 1; // ear
			}
		}
//		// print original
//		for (int[] i : moves) {
//			System.out.println(Arrays.toString(i));
//		}
//		System.out.println();

		for (int i = 1; i < n; i++) {
			movesF[0][i] += movesF[0][i-1];
			movesF[1][i] += movesF[1][i-1];
			movesF[2][i] += movesF[2][i-1];
		}
		for (int i = n-2; i >= 0; i--) {
			movesB[0][i] += movesB[0][i+1];
			movesB[1][i] += movesB[1][i+1];
			movesB[2][i] += movesB[2][i+1];
		}
		
//		// print
//		System.out.println("prefix forward");
//		for (int[] i : movesF) {
//			System.out.println(Arrays.toString(i));
//		}
//		System.out.println("prefix backward");
//		for (int[] i : movesB) {
//			System.out.println(Arrays.toString(i));
//		}
//		System.out.println();

		
		
		int max = Integer.MIN_VALUE;
		for (int k = 0; k < 3; k++) {
			for (int j = 0; j < 3; j++) {
				if (j == k) continue;
				
				for (int i = 0; i < n; i++) {
					max = Math.max(max, movesF[k][i] + movesB[j][i] - moves[k][i]);
				}
				
				
			}
		}
		System.out.println(max);
		
		
	}

}
