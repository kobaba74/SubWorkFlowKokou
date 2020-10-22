package graph;

import org.cloudbus.cloudsim.CloudletSchedulerTimeShared;

import java.util.ArrayList;
import java.util.List;

public class MyVmGraph {
    private List<MyVm> vms = new ArrayList<>();

    public List<MyVm> produceVm(Integer brokerId) {

        for (int i = 0; i < 8; i++) {
            if (i < 2) {
                addVm(i, brokerId);
            } else if (i < 4) {
                addVm(i, brokerId);
            } else if (i < 6) {
                addVm(i, brokerId);
            } else {
                addVm(i, brokerId);
            }
        }
        return vms;
    }

    private void addVm(int i, int brokerId) {
        vms.add(createVm(i, brokerId, 250, 1, 1024, 1000, 1000));
    }

    private MyVm createVm(Integer vmid, Integer brokerId, double misps, int pesNumber, int ram, int bw, int size) {

        MyVm myVm = new MyVm(vmid,
                brokerId,
                misps * vmid == 0 ? 1 : vmid,
                pesNumber * vmid == 0 ? 1 : vmid,
                ram * vmid == 0 ? 1 : vmid,
                bw * vmid == 0 ? 1 : vmid,
                size * vmid == 0 ? 1 : vmid,
                "VM_" + vmid,
                new CloudletSchedulerTimeShared());

        return myVm;
    }
}
