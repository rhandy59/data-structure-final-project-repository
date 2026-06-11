package adjacency_list;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class GraphList {
//adjacency list representation of the graph, using a LinkedHashMap to maintain insertion order and an ArrayList to store neighboring edges for each city
    private final LinkedHashMap<String, ArrayList<Edge>> adjacencyList;
//intialize the adjacency list in the constructor
    public GraphList() {
        adjacencyList = new LinkedHashMap<>();
    }
//add a location to the graph if it doesn't already exist, and add a route between two locations with the specified distance, ensuring that both locations are added to the graph and that the route is bidirectional (i.e., added in both directions)
    public void addLocation(String location) {

        adjacencyList.putIfAbsent(
                location,
                new ArrayList<>());
    }
//add a route between two locations with the specified distance, ensuring that both locations are added to the graph and that the route is bidirectional (i.e., added in both directions)
    public void addRoute(
            String source,
            String destination,
            int distance) {

        addLocation(source);
        addLocation(destination);
//add connection from source to destination and from destination to source, since the graph is undirected, and ensure that both locations are added to the graph before adding the route
        adjacencyList.get(source)
                .add(new Edge(
                        destination,
                        distance));
//add connection from destination to source, since the graph is undirected, and ensure that both locations are added to the graph before adding the route
        adjacencyList.get(destination)
                .add(new Edge(
                        source,
                        distance));
    }
//return all cities in the graph as a list, by creating a new ArrayList from the key set of the adjacency list to provide a list of all cities in the graph
    public ArrayList<String> getLocations() {

        return new ArrayList<>(
                adjacencyList.keySet());
    }
//return the neighboring edges for a given city, by retrieving the list of edges from the adjacency list for the specified city, or returning an empty list if the city does not exist in the graph
    public List<Edge> getNeighbors(
            String city) {

        return adjacencyList.getOrDefault(
                city,
                new ArrayList<>());
    }
//display the adjacency list representation of the graph, by iterating through each city and its corresponding list of neighboring edges, and printing the city along with its neighbors and the distances to those neighbors in a readable format
    public void displayGraph() {

        System.out.println(
                "\nAdjacency List:");

        for (String city : adjacencyList.keySet()) {

            System.out.print(
                    city + " -> ");

            for (Edge edge : adjacencyList.get(city)) {

                System.out.print(
                        edge.getDestination()
                                + "("
                                + edge.getDistance()
                                + " km) ");
            }

            System.out.println();
        }
    }
//represents a connection from one city to another with a specified distance, used as the value type in the adjacency list to store neighboring cities and the distances to those neighbors
    public static class Edge {

        private final String destination;
        private final int distance;

        public Edge(
                String destination,
                int distance) {

            this.destination = destination;

            this.distance = distance;
        }
//return the destination city of this edge, which represents the neighboring city that this edge connects to
        public String getDestination() {

            return destination;
        }
//return the distance associated with this edge, which represents the distance from the source city to the destination city for this particular route
        public int getDistance() {

            return distance;
        }
    }
}