package clustering;

import graph.CloudLet;

import java.util.List;

public class SpectralClustering {

    public void produce(List<CloudLet> cloudLets) {

        // The size of all Graph nodes
        int size = cloudLets.size();

        // Adjacency Matrix
        double[][] adjacencyMatrix = new double[size + 1][size + 1];

        // Degree Matrix
        int[][] degreeMatrix = new int[size + 1][size + 1];

        for (CloudLet c : cloudLets) {

            // satre entekhab shode
            Integer to = c.getIndex();

            // barae jame node haye motasel shode
            final int[] count = {0};

            // bad az chakhesh yalhaye node entekhabi arraye andise an ra barabare meghdare weight garar midahad
            c.getEdges().forEach(f -> {
                adjacencyMatrix[to][f.getDestination().getIndex()] = f.getWeight();
                count[0] += 1;
            });

            degreeMatrix[to][to] = count[0];
        }
        System.out.println();
    }
}
