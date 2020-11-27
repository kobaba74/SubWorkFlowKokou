package clustering;

import Jama.Matrix;
import graph.CloudLet;

import java.util.List;

public class SpectralClustering {

    public void produce(List<CloudLet> cloudLets) {

        // The size of all Graph nodes
        int size = cloudLets.size();

        // Adjacency Matrix
        double[][] adjacencyMatrix = new double[size + 1][size + 1];

        // Adjacency2 Matrix when have edge is -1 else 0
        double[][] laplacian = new double[size + 1][size + 1];

        // Degree Matrix
        int[][] degreeMatrix = new int[size + 1][size + 1];

        for (CloudLet c : cloudLets) {

            // satre entekhab shode
            Integer to = c.getIndex();

            // barae jame node haye motasel shode
            final int[] count = {0};

            // bad az chakhesh yalhaye node entekhabi arraye andise an ra barabare meghdare weight garar midahad
            c.getEdges().forEach(f -> {
                // set weight cloudLet index and edge to weight
                adjacencyMatrix[to][f.getDestination().getIndex()] = f.getWeight();

                // set weight cloudLet index and edge to -1
                laplacian[to][f.getDestination().getIndex()] = -1;

                count[0] += 1;
            });
            // قطر اصلی ماتریس برابر مقدار ماترین درجه است
            laplacian[to][to] = count[0];

            // پر کردن ماتریس درجه
            degreeMatrix[to][to] = count[0];
        }
        Matrix matrix = new Matrix(adjacencyMatrix);
        matrix.eig();
        Eigenvalue eigenvalue = new Eigenvalue();
        eigenvalue.produceEigenvalue(matrix);

        System.out.println();
    }
}
