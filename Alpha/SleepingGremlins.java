import java.util.Scanner;

public class SleepingGremlins {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt(); // number if bridges (interval)
		int k = in.nextInt(); // pass k bridges
		int b = in.nextInt(); // number of sleeping
		
		boolean[] g = new boolean[n];
		for (int i = 0; i < b; i++) {
			g[in.nextInt()] = true;
		}
		
		int s = 0;
		int e = s+k-1;
		int min = 0;
		for (int i = s; i <= e; i++) {
			if (g[i]) min++;
		}
		int temp = min;
		while (e <= n-2) {
			e++;
			
			if (g[e]) temp++;
			if (g[s]) temp--;
			s++;
			min = Math.min(min, temp);
		}
		
		System.out.println(min); 
	}

}

