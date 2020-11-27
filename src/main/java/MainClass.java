import clustering.SpectralClustering;
import graph.CloudLet;
import graph.CloudLetGrah;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        CloudLetGrah cloudLetGrah = new CloudLetGrah();
        List<CloudLet> cloudLets = cloudLetGrah.produceGraph();
        // print graph in console
        System.out.println(cloudLetGrah);
        SpectralClustering spectralClustering = new SpectralClustering();
        spectralClustering.produce(cloudLets);



    }
}
