package adjacency_matrix;

import java.util.LinkedList;
import java.util.Queue;

public class BFSMatrix {
    //perform a breadth-first search traversal starting from the specified city, with an option to suppress output for benchmarking purposes
    public void traverse(
            GraphMatrix graph,
            String startCity) {

        traverse(
                graph,
                startCity,
                false);
    }
    //breadth-first search traversal implementation for the adjacency matrix graph representation, with an option to suppress output for benchmarking purposes
    public void traverse(
            GraphMatrix graph,
            String startCity,
            boolean silent) {

        int start = graph.getIndex(startCity);
            //stop if the city index is invalid (i.e., the city does not exist in the graph)
        if (start == -1) {
            return;
        }

        int size = graph.getSize();

        int[][] matrix = graph.getMatrix();
        //track visited cities to avoid processing them multiple times during the BFS traversal
        boolean[] visited = new boolean[size];
        //use a queue to manage the order of city visits during the BFS traversal
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        if (!silent) {

            System.out.println(
                    "\nBFS Traversal:");
        }
//visit verticles in the order they were added to the queue, marking them as visited and adding their unvisited neighbors to the queue until all reachable vertices have been processed
        while (!queue.isEmpty()) {

            int current = queue.poll();

            if (!silent) {

                System.out.println(
                        "Visited: "
                                + graph.getCities()
                                        .get(current));
            }
//check all neighbors of the current city and add unvisited neighbors to the queue
            for (int i = 0; i < size; i++) {

                if (matrix[current][i] != 0
                        && !visited[i]) {

                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}