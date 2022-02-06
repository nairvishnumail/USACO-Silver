import java.io.IOException;
import java.util.Arrays;


public class LemonadeLine {
	public static void main(String[] args) throws IOException {

		Kattio in = new Kattio();
		int n = in.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		Arrays.sort(arr);
		
		int cows = 0;
		for (int i = n-1; i > -1; i--) {
			if (arr[i] < cows) break;
			cows++;
		}
		
		
		in.println(cows);
		in.close();
		
	}

}

