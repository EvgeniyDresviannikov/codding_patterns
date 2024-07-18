package custom.data.structures;

import java.util.*;
import java.util.LinkedList;

class SnapshotArray {

    public static void main(String[] args) {
        SnapshotArray snapshotArray = new SnapshotArray(4);
        snapshotArray.setValue(1, 100);
        snapshotArray.setValue(2, 200);
        snapshotArray.snapshot();

        snapshotArray.setValue(1, 1000);

        System.out.println(snapshotArray.getValue(1, 0));
        System.out.println(snapshotArray.getValue(1, 1));
        LinkedList<Integer> lst = new LinkedList<>();
    }

    int currentSnapId;
    Map<Integer, Map<Integer, Integer>> snapshots;
    int len;

    // Constructor
    public SnapshotArray(int length) {
        currentSnapId = 0;
        snapshots = new HashMap<>();
        len = length;
        snapshots.put(currentSnapId, new HashMap<>());
    }

    // Function setValue sets the value at a given index idx to val.
    public void setValue(int idx, int state) {
        if (idx > len-1) return;

        snapshots.get(currentSnapId).put(idx, state);
    }

    // This function takes no parameters and returns the snapid.
    // snapid is the number of times that the snapshot() function was called minus 1.
    public int snapshot() {
        currentSnapId++;
        snapshots.put(currentSnapId, new HashMap<>());
        return currentSnapId-1;
    }

    // Function getValue returns the value at the index idx with the given snapid.
    public int getValue(int idx, int snapshotId1) {
        int snapId = snapshotId1;
        while (snapId > -1) {
            Map<Integer, Integer> snap = snapshots.get(snapId);
            if (snap.containsKey(idx)) return snap.get(idx);

            snapId--;
        }

        return 0;
    }
}