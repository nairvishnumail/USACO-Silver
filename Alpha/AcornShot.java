import java.util.Arrays;
import java.util.Scanner;

public class AcornShot {
	
	public static int[] point;
	public static int n;
	public static int k;
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		k = in.nextInt();
		
		
		point = new int[n];
		for (int i = 0; i < n; i++) {
			point[i] = in.nextInt();
		}
		Arrays.sort(point);
		
		
		
		long a = 0, b = 1000000000;
		while (a != b) {
			long mid = (a + b) / 2;
			if (works(mid)) {
				b = mid;
			} else {
				a = mid + 1;
			}
		}
		System.out.println(a);
	}
	public static boolean works(long m) {
		
		long to = point[0] + (2*m);
		long done = 0;
		
		int i = 0;
		for (; i < n && done < k; i++) {
			if (point[i] > to) {
				to = point[i] + (2*m);
				done++;
			}
			if (done < k && to >= point[n-1]) return true;
		}
		
		return false;
		
	}
}
