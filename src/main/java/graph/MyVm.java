package graph;

import lombok.Getter;
import lombok.Setter;
import org.cloudbus.cloudsim.CloudletScheduler;
import org.cloudbus.cloudsim.Vm;
@Getter
@Setter
public class MyVm extends Vm {

    public MyVm(int id, int userId, double mips, int numberOfPes, int ram, long bw, long size, String vmm, CloudletScheduler cloudletScheduler) {
        super(id, userId, mips, numberOfPes, ram, bw, size, vmm, cloudletScheduler);
    }

    private Integer freeSize;
    private Integer freeRam;
    private Integer freePesNumber;

    private Integer usedSize;
    private Integer usedRam;
    private Integer usedPesNumber;




}
