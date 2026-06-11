package adjacency_matrix;

public class BenchmarkMatrix {
        //run the benchmark tests for BFS and Dijkstra's algorithm on the adjacency matrix graph representation, measuring execution time for multiple runs and iterations to calculate average performance
    public static void runBenchmark(
            GraphMatrix graph,
            BFSMatrix bfs,
            DijkstraMatrix dijkstra) {
//check if the graph is empty before running benchmarks, and display a message if it is
        if (graph.getSize() == 0) {

            System.out.println(
                    "Graph is empty.");

            return;
        }
        //nuumber of iterations to run for each algorithm in the benchmark test to get a more accurate average execution time
        int iterations = 100;
//select start and end cities for the benchmarks, using the first and last cities in the graph's city list, respectively
        String startCity = graph.getCities().get(0);

        String endCity = graph.getCities().get(
                graph.getSize() - 1);

        System.out.println(
                "\n--- ADJACENCY MATRIX RESULTS ---");
//run multiple benchmark runs to get a more reliable performance measurement, and display the results for each run
        for (int run = 1; run <= 3; run++) {

            System.out.println(
                    "\n===== ADJACENCY MATRIX - RUN "
                            + run
                            + " =====");
//measure the execution time for BFS and Dijkstra's algorithm over the specified number of iterations, and calculate the average time per run for each algorithm
            long bfsStart = System.nanoTime();

            for (int i = 0; i < iterations; i++) {

                bfs.traverse(
                        graph,
                        startCity,
                        true);
            }

            long bfsEnd = System.nanoTime();
//measure the execution time for Dijkstra's algorithm over the specified number of iterations, and calculate the average time per run
            long dijkstraStart = System.nanoTime();

            for (int i = 0; i < iterations; i++) {

                dijkstra.shortestPath(
                        graph,
                        startCity,
                        endCity,
                        true);
            }

            long dijkstraEnd = System.nanoTime();
//convert nanoseconds to milliseconds for easier readability in the benchmark results, and display the total and average execution times for both BFS and Dijkstra's algorithm
            double bfsMs = (bfsEnd - bfsStart)
                    / 1_000_000.0;

            double dijkstraMs = (dijkstraEnd - dijkstraStart)
                    / 1_000_000.0;
//diplay total execution time for BFS and Dijkstra's algorithm, as well as the average time per run for each algorithm based on the number of iterations
            System.out.printf(
                    "BFS (%d runs): %.3f ms%n",
                    iterations,
                    bfsMs);

            System.out.printf(
                    "Dijkstra (%d runs): %.3f ms%n",
                    iterations,
                    dijkstraMs);
//display the average execution time per run for both BFS and Dijkstra's algorithm, calculated by dividing the total execution time by the number of iterations
            System.out.printf(
                    "Average BFS: %.6f ms/run%n",
                    bfsMs / iterations);

            System.out.printf(
                    "Average Dijkstra: %.6f ms/run%n",
                    dijkstraMs / iterations);
        }
    }
}