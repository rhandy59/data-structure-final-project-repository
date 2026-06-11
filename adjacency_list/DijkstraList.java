package adjacency_list;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraList {
//represents a node in the priority queue used for Dijkstra's algorithm, containing the city name and the current distance from the starting city, and implements Comparable to allow sorting by distance in the priority queue
    static class Node {

        String city;
        int distance;

        public Node(
                String city,
                int distance) {

            this.city = city;
            this.distance = distance;
        }
    }
//run dijkstra's algorithm to find the shortest path from the starting city to all other cities in the graph, with an option to suppress output for benchmarking purposes
    public static void shortestPath(
            GraphList graph,
            String start) {

        dijkstraInternal(
                graph,
                start,
                false);
    }

    public static void shortestPathSilent(
            GraphList graph,
            String start) {

        dijkstraInternal(
                graph,
                start,
                true);
    }
//dijkstra's algorithm implementation for the adjacency list graph representation, which uses a priority queue to efficiently find the shortest path from the starting city to all other cities in the graph, and updates distances to neighboring cities as it processes each city
    private static void dijkstraInternal(
            GraphList graph,
            String start,
            boolean silent) {
//check if the starting city exists in the graph, and if not, print an error message and return without performing the algorithm
        if (!graph.getLocations()
                .contains(start)) {

            System.out.println(
                    "Starting city not found.");

            return;
        }
//store the shortest distance from the start city to each city, initialized to infinity (or a very large number), and use a priority queue to manage the cities to be processed based on their current shortest distance from the start city
        HashMap<String, Integer> distance = new HashMap<>();

        for (String city : graph.getLocations()) {

            distance.put(
                    city,
                    Integer.MAX_VALUE);
        }

        distance.put(start, 0);
//priority queue to process cities based on their current shortest distance from the start city, with a custom comparator to sort by distance, and add the starting city to the priority queue with a distance of 0
        PriorityQueue<Node> pq = new PriorityQueue<>(
                Comparator.comparingInt(
                        n -> n.distance));

        pq.add(
                new Node(start, 0));

        while (!pq.isEmpty()) {

            Node current = pq.poll();
//skip if a shorter path to the current city has already been found, which can happen because a city may be added to the priority queue multiple times with different distances as shorter paths are discovered
            if (current.distance > distance.get(
                    current.city)) {

                continue;
            }
//update the distance to neighboring cities of the current city, and add those neighbors to the priority queue if a shorter path is found through the current city
            for (GraphList.Edge edge : graph.getNeighbors(
                    current.city)) {

                int newDistance = distance.get(
                        current.city)
                        + edge.getDistance();

                if (newDistance < distance.get(
                        edge.getDestination())) {

                    distance.put(
                            edge.getDestination(),
                            newDistance);

                    pq.add(
                            new Node(
                                    edge.getDestination(),
                                    newDistance));
                }
            }
        }
//display the shortest distance from the starting city to all other cities in the graph, unless the silent flag is set to true for benchmarking purposes, in which case the distances are calculated but not printed
        if (!silent) {

            System.out.println(
                    "\nShortest Distance from "
                            + start);

            for (String city : graph.getLocations()) {

                System.out.println(
                        start
                                + " -> "
                                + city
                                + " = "
                                + distance.get(city)
                                + " km");
            }
        }
    }
}