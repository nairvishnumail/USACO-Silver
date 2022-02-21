import java.util.Scanner;
public class Leprechaun {

	public static int maxCircularSum(int a[], int n) {
		// Corner Case
		if (n == 1)
			return a[0];

		// Initialize sum variable which store total sum of
		// the array.
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
		}

		// Initialize every variable with first value of
		// array.
		int curr_max = a[0], max_so_far = a[0], curr_min = a[0],
				min_so_far = a[0];

		// Concept of Kadane's Algorithm
		for (int i = 1; i < n; i++) {

			// Kadane's Algorithm to find Maximum subarray
			// sum.
			curr_max = Math.max(curr_max + a[i], a[i]);
			max_so_far = Math.max(max_so_far, curr_max);

			// Kadane's Algorithm to find Minimum subarray
			// sum.
			curr_min = Math.min(curr_min + a[i], a[i]);
			min_so_far = Math.min(min_so_far, curr_min);
		}
		if (min_so_far == sum) {
			return max_so_far;
		}

		// returning the maximum value
		return Math.max(max_so_far, sum - min_so_far);
	}

	// Driver code
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[][] input = new int[n][n];
		int[][] col = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				input[i][j] = in.nextInt();
				col[j][i] = input[i][j];
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, maxCircularSum(input[i], n));
			max = Math.max(max, maxCircularSum(col[i], n));
		}
		for (int r = 0; r < n; r++) {
			int[] temp = new int[n];
			
			int r1 = r;
			int c1 = 0;
			for (int d = 0; d < n; d++) {
				if (r1 >= n) {
					r1 = 0;
					c1 = n-r;
				}
				
				temp[d] = input[r1][c1];
				r1++;
				c1++;
			}
			//System.out.println(Arrays.toString(temp));
			max = Math.max(max, maxCircularSum(temp, n));
			//---
			
			r1 = r;
			c1 = n-1;
			for (int d = 0; d < n; d++) {
				if (r1 >= n) {
					r1 = 0;
					c1 = r - 1;
				}
				
				temp[d] = input[r1][c1];
				r1++;
				c1--;
			}
			//System.out.println(Arrays.toString(temp));
			max = Math.max(max, maxCircularSum(temp, n));
		}
		
		System.out.println(max);
	}

}
