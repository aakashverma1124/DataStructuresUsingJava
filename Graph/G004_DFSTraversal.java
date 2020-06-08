/*

   	@author
   	Aakash Verma

   	BFS - Depth First Traversal on Graph

	Output: 2 1 3 5 7 6 4

	
	output for utility code written in main:
	0 : 
	1 : 2 3 4 
	2 : 1 6 
	3 : 1 5 
	4 : 1 6 
	5 : 3 7 
	6 : 2 4 7 
	7 : 6 5 

	Approach: 

	Whatever source node is given to us, we first explore all the nodes connected to it(inclusive) but,
	as we start exploring node, we immediately call dfs() function to the explored vertex.
	This will be performed until our recursive stack becomes empty.(or all recursive calls are completed)

*/

import java.io.*; 
import java.util.*;

class G004_DFSTraversal {

	private int vertices;
	private LinkedList<Integer> list[];

	G004_DFSTraversal(int vertices) {
		this.vertices = vertices;
		list = new LinkedList[vertices];
		for(int i = 0; i < vertices; i++) {
			list[i] = new LinkedList<>();
		}
	}

	public void addEdge(int u, int v) {
		/* connecting u to v */
		list[u].add(v);
		/* connecting v to u back */
		list[v].add(u);
	}

	public void depthFirstTraversal(int s, boolean visited[]) {

		/* marking source node as visited */
		visited[s] = true;
		System.out.print(s + " ");
		
		Iterator<Integer> i = list[s].listIterator(); 
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				depthFirstTraversal(n, visited);
			}
		}

	}

	public static void main(String[] args) {
		
		G004_DFSTraversal graph = new G004_DFSTraversal(8); 
        graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 6);
		graph.addEdge(3, 5);
		graph.addEdge(4, 6);
		graph.addEdge(6, 7);
		graph.addEdge(5, 7);
		boolean visited[] = new boolean[graph.vertices];
        graph.depthFirstTraversal(2, visited);
        System.out.println();

        /* utility code for printing the list array */
        
        /*
        for(int i = 0; i < graph.list.length; i++) {
        	System.out.print(i + " : ");
        	Iterator<Integer> it = graph.list[i].listIterator(); 
        	while(it.hasNext()) {
        		System.out.print(it.next() + " ");
        	}
        	System.out.println();
        }
        */

	}



}