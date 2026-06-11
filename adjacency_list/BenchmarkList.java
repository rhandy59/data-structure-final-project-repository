package adjacency_list;

public class BenchmarkList {
//run performance benchmarks for BFS and Dijkstra's algorithm on the provided graph, executing multiple runs and iterations to calculate average execution times for both algorithms, and displaying the results in a readable format
    public static void runBenchmark(GraphList graph) {
//check if the graph is empty before running benchmarks, and display a message if it is
        if (graph.getLocations().isEmpty()) {

            System.out.println(
                    "Graph is empty.");

            return;
        }
//number of iterations to run for each algorithm in the benchmark test to get a more accurate average execution time
        int iterations = 100;
//select start city for the benchmarks, using the first city in the graph's location list as the starting point for both BFS and Dijkstra's algorithm
        String startCity = graph.getLocations().get(0);

        System.out.println(
                "\n--- ADJACENCY LIST RESULTS ---");
//run benchmark three times to get a more reliable performance measurement, and display the results for each run
        for (int run = 1; run <= 3; run++) {

            System.out.println(
                    "\n===== ADJACENCY LIST - RUN "
                            + run
                            + " =====");
//measure the execution time for BFS and Dijkstra's algorithm over the specified number of iterations, and calculate the average time per run for each algorithm, while using the silent versions of the algorithms to avoid the overhead of printing to the console during benchmarking
            long bfsStart = System.nanoTime();

            for (int i = 0; i < iterations; i++) {

                BFSList.bfsSilent(
                        graph,
                        startCity);
            }

            long bfsEnd = System.nanoTime();

            long dijkstraStart = System.nanoTime();

            for (int i = 0; i < iterations; i++) {

                DijkstraList.shortestPathSilent(
                        graph,
                        startCity);
            }

            long dijkstraEnd = System.nanoTime();
//convert nanoseconds to milliseconds for easier readability in the benchmark results, and display the total and average execution times for both BFS and Dijkstra's algorithm
            double bfsMs = (bfsEnd - bfsStart)
                    / 1_000_000.0;

            double dijkstraMs = (dijkstraEnd - dijkstraStart)
                    / 1_000_000.0;

            System.out.printf(
                    "BFS (%d runs): %.3f ms%n",
                    iterations,
                    bfsMs);

            System.out.printf(
                    "Dijkstra (%d runs): %.3f ms%n",
                    iterations,
                    dijkstraMs);
        //display average execution time per run for both BFS and Dijkstra's algorithm based on the number of iterations, providing insight into the performance of each algorithm on the adjacency list representation of the graph
            System.out.printf(
                    "Average BFS: %.6f ms/run%n",
                    bfsMs / iterations);

            System.out.printf(
                    "Average Dijkstra: %.6f ms/run%n",
                    dijkstraMs / iterations);
        }
    }
}