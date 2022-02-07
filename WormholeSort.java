//    9/10 test cases
      // 5th case does not work... Not sure why
//http://www.usaco.org/index.php?page=viewproblem2&cpid=992

import java.io.IOException;
import java.util.ArrayList;
//import java.util.Arrays;   // <-- uncomment to print for Arrays.toString()



public class WormholeSort {
	
	public static ArrayList<Integer> wrongPos = new ArrayList<>();
	public static ArrayList[] connections;
	public static int cows;
	public static boolean[] weightVisit;
	
	public static void main(String[] args) throws IOException {
		
		Kattio in = new Kattio();
		cows = in.nextInt();
		int connect = in.nextInt();
		
		// input
		connections = new ArrayList[cows+1];
		for (int i = 1; i <= cows; i++) {
			connections[i] = new ArrayList<Node>();
			
			if (in.nextInt() != i) wrongPos.add(i);
		}
		connections[cows] = new ArrayList<Node>();
		
		
		// if it's already sorted
		if (wrongPos.size() == 0) {
			in.println(-1);
			in.close();
		} 
		// otherwise
		else {

			// getting smallest & largest possible weight
			int minW = Integer.MAX_VALUE;
			int maxW = Integer.MIN_VALUE;

			// more input
			for (int i = 0; i < connect; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				int weight = in.nextInt();

				minW = Math.min(minW, weight);
				maxW = Math.max(maxW, weight);

				connections[from].add(new Node(to, weight));
				connections[to].add(new Node(from, weight));
			}

			
// uncomment this if you want to see how it currently looks like
			// System.out.println(wrongPos.toString());
			// System.out.println(Arrays.deepToString(connections));
			// System.out.println(Arrays.toString(cow));

			// System.out.println();
			// System.out.println(minW + " " + maxW);
			// System.out.println();

			
			
			// binary searching the best weight
			int a = minW, b = maxW;
			while (a != b) {
				int mid = (a + b + 1) / 2;
				if (works(mid)) {
					a = mid;
				} else {
					b = mid - 1;
				}
			}

			in.println(a);
			in.close();
		}

	}
	
	// returns if weight works or not
	// starts the dfs function
	public static boolean works(int weight) {
		
		// weightVisit is checking if it can actually reach with the current weight
		weightVisit = new boolean[cows+1];
		// dfs normal visited boolean array, so I don't repeat
		boolean[] visited = new boolean[cows+1];
		
		
		// starting dfs
		for (int i = 1; i <= cows; i++) {
			if (visited[i]) continue;
			visited = dfs(i, weight, visited);
		}
		
		// checking if all the unsorted cows were sorted
		for (Integer i : wrongPos) {
			if (!weightVisit[i]) return false;
		}
		return true;
		
	}
	
	// recursive dfs
	public static boolean[] dfs(int cow, int weight, boolean[] visited) {
		if (visited[cow]) return visited;
		
		visited[cow] = true;
		ArrayList<Node> a = connections[cow];
		
		for (Node i : a) {
			// if greater than: set current position & the place going to as true & continue
			if (i.weight >= weight) {
				weightVisit[cow] = true;
				weightVisit[i.to] = true;
				dfs(i.to, weight, visited);
			}
		}
		
		
		return visited;
	}
	

}

// index of array is whcih cow it is from
// Node holds: which cow it is to & the weight of the wormholw
class Node {
	
	int to;
	int weight;
	
	public Node(int t, int w) {
		to = t;
		weight = w;
	}
	
	
	public String toString() {
		return ("[" + to + " " + weight + "]");
	}
}
