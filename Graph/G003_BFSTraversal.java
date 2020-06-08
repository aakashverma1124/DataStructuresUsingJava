/*

   	@author
   	Aakash Verma

   	BFS - Breadth First Traversal on Graph

	Output: 2 1 6 3 4 7 5

	Approach: 

	Whatever source node is given to us, we first explore all the nodes connected to it(inclusive) and add them 
	into a queue, also whichever node we visit we mark it as visited, to do so, I need to have a boolean
	visited[] array.
	Then we poll out each element out of the queue and repeat the same.
	We perform this activity until the queue becomes empty.

*/

import java.io.*; 
import java.util.*;

class G003_BFSTraversal {

	private int vertices;
	private LinkedList<Integer> list[];

	G003_BFSTraversal(int vertices) {
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

	public void breadthFirstTraversal(int s) {
		
		/* creating a boolean visited array */
		boolean visited[] = new boolean[vertices];
		/* creating a queue */
		LinkedList<Integer> queue = new LinkedList<>();
		/* marking source node as visited */
		visited[s] = true;
		/* adding it into the queue */
		queue.add(s);

		/* condition */
		while(queue.size() != 0) {
			/* polling out each element out of the queue */
			s = queue.poll();
			System.out.print(s + " ");

			/* 
				whavever element we have now, we go to the list at that index, and adding each element
				into the queue marking as visited, if it not visited.
			*/
			Iterator<Integer> i = list[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}

	}

	public static void main(String[] args) {
		
		G003_BFSTraversal graph = new G003_BFSTraversal(8); 
        graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 6);
		graph.addEdge(3, 5);
		graph.addEdge(4, 6);
		graph.addEdge(6, 7);
		graph.addEdge(5, 7);
        graph.breadthFirstTraversal(2);
        System.out.println();

	}



}