package adjacency_matrix;

import java.util.Arrays;

public class DijkstraMatrix {
    //find the shortest path between two cities using Dijkstra's algorithm on the adjacency matrix representation of the graph
    public void shortestPath(
            GraphMatrix graph,
            String startCity,
            String endCity) {

        shortestPath(
                graph,
                startCity,
                endCity,
                false);
    }
    //Dijkstra's algorithm implementation for the adjacency matrix graph representation, with an option to suppress output for benchmarking purposes
    public void shortestPath(
            GraphMatrix graph,
            String startCity,
            String endCity,
            boolean silent) {

        int n = graph.getSize();

        int[][] matrix = graph.getMatrix();
            //store the shortest distance from the start city to each city, initialized to infinity (or a very large number)
        int[] distance = new int[n];
        //Track visited cities to avoid processing them multiple times
        boolean[] visited = new boolean[n];

        Arrays.fill(
                distance,
                Integer.MAX_VALUE);

        int start = graph.getIndex(startCity);

        int end = graph.getIndex(endCity);
            //stop if the city indices are invalid (i.e., one or both cities do not exist in the graph)
        if (start == -1 || end == -1) {
            return;
        }

        distance[start] = 0;
        //Find shortest path to all vertices in the graph
        for (int count = 0; count < n - 1; count++) {

            int u = -1;
            int min = Integer.MAX_VALUE;
            //Select the unvisited vertex with the smallest distance
            for (int i = 0; i < n; i++) {

                if (!visited[i]
                        && distance[i] < min) {

                    min = distance[i];
                    u = i;
                }
            }

            if (u == -1) {
                break;
            }

            visited[u] = true;
            //Update the distance to neighboring vertices of the selected vertex
            for (int v = 0; v < n; v++) {

                if (!visited[v]
                        && matrix[u][v] != 0
                        && distance[u] != Integer.MAX_VALUE
                        && distance[u]
                                + matrix[u][v] < distance[v]) {

                    distance[v] = distance[u]
                            + matrix[u][v];
                }
            }
        }
        //display the shortest distance from the start city to the destination city, unless silent mode is enabled for benchmarking
        if (!silent) {

            System.out.println(
                    "\nShortest Distance: "
                            + distance[end]);
        }
    }
}