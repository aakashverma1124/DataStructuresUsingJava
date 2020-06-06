/*

   	@author
   	Aakash Verma

   	Graph Creation using Adjacency List in Java

	Output:

	0 0 0 0 0 0 0 0 
	0 0 1 1 1 0 0 0 
	0 1 0 0 0 0 1 0 
	0 1 0 0 0 1 0 0 
	0 1 0 0 0 0 1 0 
	0 0 0 1 0 0 0 1 
	0 0 1 0 1 0 0 1 
	0 0 0 0 0 1 1 0 
	Vertex 0 is connected to: 
	Vertex 1 is connected to: 2 3 4 
	Vertex 2 is connected to: 1 6 
	Vertex 3 is connected to: 1 5 
	Vertex 4 is connected to: 1 6 
	Vertex 5 is connected to: 3 7 
	Vertex 6 is connected to: 2 4 7 
	Vertex 7 is connected to: 5 6

*/

import java.util.*;

class G002_AdjacencyMatrix {

	/* Declaring the vertex & a matrix of size V * V */
	int vertex;
	int matrix[][];

	/* 
		Constructor:
		Whenever we will create an object of Graph, we'll have the number of vertices.
		Now, we will just initialize our matrix using 'new int[vertex][vertex]'.
	*/
	public G002_AdjacencyMatrix(int vertex) {
		this.vertex = vertex;
		matrix = new int[vertex][vertex];
	}

	/* 
		Utility function that will accept two integers which will represents a two way connection 
	 	between two vertices.
	*/
	public void addEdge(int u, int v) {
		/* connecting u to v */
		matrix[u][v] = 1;
		/* connecting v to u back */
		matrix[v][u] = 1;
	}


	/* Utility function to print graph */
	public void printGraph() {

		/* printing matrix */
		for(int i = 0; i < vertex; i++) {
			for(int j = 0; j < vertex; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		/* printing graph */ 
		for(int i = 0; i < vertex; i++) {
			System.out.print("Vertex " + i + " is connected to: ");
			for(int j = 0; j < vertex; j++) {
				if(matrix[i][j] == 1) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}

	}

	/* main method */
	public static void main(String[] args) {
		G002_AdjacencyMatrix graph = new G002_AdjacencyMatrix(8);
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