package adjacency_matrix;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphMatrix {
    //Storage for cities, their indices, and the adjacency matrix
    private final ArrayList<String> cities;
    private final HashMap<String, Integer> cityIndices;
    private final int[][] matrix;
    //current number of cities in the graph
    private int size;

    public GraphMatrix(int maxCities) {

        cities = new ArrayList<>();
        cityIndices = new HashMap<>();

        matrix = new int[maxCities][maxCities];

        size = 0;
    }
//add a city if it doesn't exist, then add a road between the two cities with the specified distance

    public void addLocation(String city) {

        if (!cityIndices.containsKey(city)) {
            //initialize the new city in the adjacency matrix with 0 (no roads)
            cities.add(city);

            cityIndices.put(
                    city,
                    size);

            size++;
        }
    }
//get the index of a city in the adjacency matrix, return -1 if the city does not exist
    public int getIndex(String city) {

        return cityIndices.getOrDefault(
                city,
                -1);
    }
    // add a road between two cities with the specified distance, update the adjacency matrix accordingly
    public void addRoad(
            String city1,
            String city2,
            int distance) {

        int i = getIndex(city1);

        int j = getIndex(city2);
        // ignore if either city does not exist in the graph
        if (i == -1 || j == -1) {
            return;
        }
        //store the distance in both directions since the graph is undirected
        matrix[i][j] = distance;

        matrix[j][i] = distance;
    }
//display the adjacency matrix in a readable format
    public void displayGraph() {

        System.out.println(
                "\nAdjacency Matrix:");

        System.out.print(
                "          ");

        for (String city : cities) {

            System.out.printf(
                    "%10s",
                    city);
        }

        System.out.println();

        for (int i = 0; i < size; i++) {

            System.out.printf(
                    "%10s",
                    cities.get(i));

            for (int j = 0; j < size; j++) {

                System.out.printf(
                        "%10d",
                        matrix[i][j]);
            }

            System.out.println();
        }
    }
//return the adjacency matrix, list of cities, and current size of the graph
    public int[][] getMatrix() {
        return matrix;
    }
//return the list of cities in the graph
    public ArrayList<String> getCities() {
        return cities;
    }
//return the current number of cities in the graph
    public int getSize() {
        return size;
    }
}