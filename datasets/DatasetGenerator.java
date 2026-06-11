package datasets;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;

public class DatasetGenerator {
        // Generate a random graph dataset and save it to a CSV file
    public static void generate(
            String filename,
            int vertices,
            int edges) throws IOException {

        Random rand = new Random();

        FileWriter writer = new FileWriter(filename);
        //Write the header line for the CSV file
        writer.write(
                "source,destination,distance\n");
        //Store existing edges to avoid duplicates
        HashSet<String> usedEdges = new HashSet<>();

        // Ensure graph connectivity
        for (int i = 1; i < vertices; i++) {

            String source = "City" + i;

            String destination = "City" + (i + 1);

            int distance = rand.nextInt(1000) + 1;

            writer.write(
                    source + ","
                            + destination + ","
                            + distance + "\n");

            usedEdges.add(
                    source + "-"
                            + destination);

            usedEdges.add(
                    destination + "-"
                            + source);
        }

        int currentEdges = vertices - 1;
        // Add random edges until the number of edges reaches the specified count
        while (currentEdges < edges) {

            int sourceId = rand.nextInt(vertices) + 1;

            int destinationId = rand.nextInt(vertices) + 1;
                //prevent self-loops and duplicate edges
            if (sourceId == destinationId) {
                continue;
            }

            String source = "City" + sourceId;

            String destination = "City" + destinationId;

            String edgeKey = source + "-"
                    + destination;
            //skip if the edge already exists
            if (usedEdges.contains(
                    edgeKey)) {

                continue;
            }

            int distance = rand.nextInt(1000) + 1;

            writer.write(
                    source + ","
                            + destination + ","
                            + distance + "\n");

            usedEdges.add(
                    source + "-"
                            + destination);

            usedEdges.add(
                    destination + "-"
                            + source);

            currentEdges++;
        }

        writer.close();
        //Display a message indicating that the dataset has been generated successfully
        System.out.println(
                filename
                        + " generated successfully.");
    }

    public static void main(
            String[] args)
            throws IOException {

        // Generate datasets for both sparse and dense graphs
        generate(
                "small.csv",
                100,
                300);

        generate(
                "medium.csv",
                500,
                1500);

        generate(
                "large.csv",
                1000,
                3000);

        // Generate dense graph datasets with a higher number of edges
        generate(
                "dense_small.csv",
                100,
                4000);

        generate(
                "dense_medium.csv",
                500,
                50000);

        generate(
                "dense_large.csv",
                1000,
                200000);
    }
}