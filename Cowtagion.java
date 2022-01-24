import java.util.ArrayList;

public class Cowtagion {
	
	public static ArrayList[] arr;
	public static long count = -1;
	public static boolean visited[];
	public static int upper;
	public static long[] doubles = new long[101];
	
	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		
		arr = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for (int i = 1; i < n; i++) {
			int num1 = fr.nextInt();
			int num2 = fr.nextInt();
			if (arr[num1] == null) arr[num1] = new ArrayList<Integer>();
			if (arr[num2] == null) arr[num2] = new ArrayList<Integer>();
			
			arr[num1].add(num2);
			arr[num2].add(num1);
		}

		
		//System.out.println(Arrays.deepToString(arr));

		
		dfs(1);
		
		System.out.println(count);
		
	}
	
	
	public static void dfs(int index) {
		count++;
		visited[index] = true;
		
		long num = 1;
		for (int i = 0; i < arr[index].size(); i++) {
			if (!visited[(int) arr[index].get(i)]) {
				num++;
				dfs((int) arr[index].get(i));
			}
		}
		
		//System.out.print(num + " " + index);

		int doublingDays = 0;
		while (Math.pow(2, doublingDays) < num) doublingDays++;
		
		//System.out.println(" " + doublingDays);
		
		count += doublingDays;
	}

}
