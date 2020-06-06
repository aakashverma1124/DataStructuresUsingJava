/*

   	@author
   	Aakash Verma

   	Graph Creation using Adjacency List in Java

	Output:
	 
	Vertex 1 is connected to: 2 3 4 
	Vertex 2 is connected to: 1 6 
	Vertex 3 is connected to: 1 5 
	Vertex 4 is connected to: 1 6 
	Vertex 5 is connected to: 3 7 
	Vertex 6 is connected to: 2 4 7 
	Vertex 7 is connected to: 6 5

*/

import java.util.*;

class Graph {

	/* Declaring the numberOfVertices & an array of LinkedList of type Integers */
	int numberOfVertices;
	LinkedList<Integer> list[];

	/* 
		Constructor:
		Whenever we will create an object of Graph, we'll have the number of vertices and size of
		LinkedList that we are creating.	
		Now for each list present in the list[], we need to initialize it. So, we are iterating over the 
		list array and initializing it.
		Something like this: l = new LinkedList<>()
	*/
	public Graph(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		list = new LinkedList[numberOfVertices];

		for (int i = 0; i < numberOfVertices; i++) {
            		list[i] = new LinkedList<Integer>();
        	}
	}

	/* 
		Utility function that will accept two integers which will represents a two way connection 
	 	between two vertices.
	*/
	public void addEdge(int u, int v) {
		/* connecting u to v */
		list[u].add(v);
		/* connecting v to u back */
		list[v].add(u);
	}

	/* 
		In the above function, we are actually going at uth index of the list[], and adding v to
		the list present at uth index in list[].
		For example: If I call addEdge(2, 5) & again addEdge(2, 6);
		[0] => [...]
		[1] => [...]
		[2] => [5, 6]
		[3] => [...]
		 .
		 .
		 .
		[...] simply represents that may be we have called addEdge() function to indices 0, 1, 3
		in similar fashion.
	*/


	/* Utility function to print graph */
	public void printGraph() {

		for(int i = 0; i < numberOfVertices; i++) {
			if(list[i].size() > 0) {
				System.out.print("Vertex " + i + " is connected to: ");
				for(int j = 0; j < list[i].size(); j++) {
					System.out.print(list[i].get(j) + " ");
				}
			}

			System.out.println();
		}

	}

	/* main method */
	public static void main(String[] args) {
		Graph graph = new Graph(8);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 6);
		graph.addEdge(3, 5);
		graph.addEdge(4, 6);
		graph.addEdge(6, 7);
		graph.addEdge(5, 7);
		graph.printGraph();
	}
}
