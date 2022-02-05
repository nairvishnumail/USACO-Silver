//   10/10 test cases
//   http://www.usaco.org/index.php?page=viewproblem2&cpid=788


import java.io.IOException;
import java.util.ArrayList;

public class MooTube {
	
	public static ArrayList<Edge>[] arr;
	
	public static void main(String[] args) throws IOException {
		
		Kattio in = new Kattio();
		int n = in.nextInt();
		int q = in.nextInt();
		
		arr = new ArrayList[n+1]; // 1 index
		for (int i = 0; i < n+1; i++) {
            arr[i] = new ArrayList<Edge>();
        }
		for (int i = 0; i < (n-1); i++) {
			int first = in.nextInt();
			int second = in.nextInt();
			int weight = in.nextInt();
			
			arr[first].add(new Edge(second, weight));
			arr[second].add(new Edge(first, weight));
			
			
		}
		
		
		
		for (int i = 0; i < q; i++) {
            int k = in.nextInt();
            int start = in.nextInt();
            
            boolean[] visited = new boolean[n+1];
            visited[start] = true;
            
            //System.out.println(dfs(k, start, visited));
            int max = 0;
            for (int j = 0; j < arr[start].size(); j++) {
            	Edge to = arr[start].get(j);
            	max += dfs(k, to.to, visited, to.weight);
            }
           System.out.println(max);
        }

		//in.close();
		
	
	}
	
	
	public static int dfs(int k, int cow, boolean[] visited, int minRelevance) {
		if (visited[cow]) return 0;
		visited[cow] = true;
		
		if (minRelevance < k) return 0;
		
		int max = 0;
		for (int j = 0; j < arr[cow].size(); j++) {
        	Edge to = arr[cow].get(j);
        	
        	max += dfs(k, to.to, visited, Math.min(minRelevance, to.weight));
        }
		return max+1;
	}
	
	
}

class Edge{
    public int to, weight;

    public Edge(int to, int weight) {
        this.to = to;
        //this.from = from;
        this.weight = weight;
    }
}

