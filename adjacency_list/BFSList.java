package adjacency_list;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFSList {
//perform a breadth-first search traversal starting from the specified city, with an option to suppress output for benchmarking purposes
    public static void bfs(
            GraphList graph,
            String start) {

        bfsInternal(
                graph,
                start,
                false);
    }
//perform BFS traversal without displaying output, useful for benchmarking the traversal time without the overhead of printing to the console
    public static void bfsSilent(
            GraphList graph,
            String start) {

        bfsInternal(
                graph,
                start,
                true);
    }
//breadt first search using adjacency list representation, which uses a queue to manage the order of city visits and a hash set to track visited cities, ensuring that each city is processed only once during the traversal
    private static void bfsInternal(
            GraphList graph,
            String start,
            boolean silent) {
//check if the starting city exists in the graph, and if not, print an error message and return without performing the traversal
        if (!graph.getLocations()
                .contains(start)) {

            System.out.println(
                    "Starting city not found.");

            return;
        }
//queue used for BFS traversal to manage the order of city visits, and a hash set to track visited cities to avoid processing the same city multiple times during the traversal
        Queue<String> queue = new LinkedList<>();
//store visited cities to avoid processing them multiple times during the BFS traversal, using a HashSet for efficient lookups to check if a city has already been visited
        HashSet<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        if (!silent) {

            System.out.println(
                    "\nBFS Traversal:");
        }
//visit cities level by level, starting from the specified city, and for each city visited, add its unvisited neighbors to the queue and mark them as visited until all reachable cities have been processed, ensuring that the traversal covers all cities connected to the starting city in a breadth-first manner
        while (!queue.isEmpty()) {

            String current = queue.poll();

            if (!silent) {

                System.out.print(
                        current + " ");
            }
//explore neighbors of the current city, and for each unvisited neighbor, add it to the queue and mark it as visited to ensure that it will be processed in subsequent iterations of the BFS traversal, while also preventing cycles and redundant processing of cities that have already been visited
            for (GraphList.Edge edge : graph.getNeighbors(current)) {

                if (!visited.contains(
                        edge.getDestination())) {

                    visited.add(
                            edge.getDestination());

                    queue.add(
                            edge.getDestination());
                }
            }
        }

        if (!silent) {

            System.out.println();
        }
    }
}