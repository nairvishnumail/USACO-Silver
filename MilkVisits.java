import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MilkVisits {
	
	public static int[] position;
	//public static ArrayList<ArrayList<Integer>> similar = new ArrayList<>();
	public static int point = 0;
	public static ArrayList[] tree;
	public static char[] cow;
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		Kattio in = new Kattio("milkvisits");
		int n = in.nextInt();
		int m = in.nextInt();
		
		cow = in.next().toCharArray();
	//System.out.println(Arrays.toString(cow));
		tree = new ArrayList[n+1];

		for (int i = 0; i < n-1; i++) {
			int first = in.nextInt();
			int second = in.nextInt();
			
			if (tree[first] == null) {
				tree[first] = new ArrayList<Integer>();
			}
			if (tree[second] == null) {
				tree[second] = new ArrayList<Integer>();
			}
			
			tree[first].add(second);
			tree[second].add(first);
		}
		
		position = new int[n+1];
		//position[0] = -1;
		visited = new boolean[n+1];
		
		for (int i = 1; i <= n; i++) {
			if (position[i] == 0) {
				point++;
				dfs(i);
			}
		}
		
		//System.out.println(Arrays.toString(position));
		
		
		for (int i = 0; i < m; i++) {
			int first = in.nextInt();
			int second = in.nextInt();
			char cowFav = in.next().toCharArray()[0];
			
			if (position[first] != position[second]) { // H G H
				in.print(1);
			}
			else if (cow[first - 1] == cowFav) {
				in.print(1);
			}
			else {
				in.print(0);
			}
			
		}
		
		in.close();
		
		
	}
	
	
	public static void dfs(int index) {
		if (position[index] != 0) return;
		position[index] = point;
		
		ArrayList<Integer> a = tree[index];
		for (int i : a) {
			if (cow[index - 1] == cow[i - 1]) dfs(i);
		}
		
		return;
		
	}
	
}
