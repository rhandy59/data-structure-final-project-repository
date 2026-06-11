package datasets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import adjacency_list.GraphList;
import adjacency_matrix.GraphMatrix;

public class DatasetLoader {
        // Load the dataset from a CSV file and populate both graph representations
    public static void loadCSV(
            String filename,
            GraphList graphList,
            GraphMatrix graphMatrix) {

        try (BufferedReader br = new BufferedReader(
                new FileReader(filename))) {

            String line;
                // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                //split the line into source, destination, and distance
                String[] data = line.split(",");

                String source = data[0];

                String destination = data[1];

                int distance = Integer.parseInt(
                        data[2]);
                        // Add the locations and roads to both graph representations
                graphList.addLocation(
                        source);

                graphList.addLocation(
                        destination);

                graphMatrix.addLocation(
                        source);

                graphMatrix.addLocation(
                        destination);
                //add the route to both graph representations
                graphList.addRoute(
                        source,
                        destination,
                        distance);

                graphMatrix.addRoad(
                        source,
                        destination,
                        distance);
            }

        } catch (IOException e) {
                //Display an error message if the file cannot be loaded
            e.printStackTrace();
        }
    }
}