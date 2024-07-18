package custom.data.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeStamp {

    public static void main(String[] args) {
        TimeStamp timeStamp = new TimeStamp();
        timeStamp.setValue("aaa", "a-val3", 3);
        timeStamp.setValue("aaa", "a-val6", 6);
        timeStamp.setValue("aaa", "a-val9", 9);
        timeStamp.setValue("aaa", "a-val11", 11);
        timeStamp.setValue("aaa", "a-val15", 15);
        timeStamp.setValue("aaa", "a-val20", 20);
        timeStamp.setValue("bbb", "b-val35", 35);
        timeStamp.setValue("bbb", "b-val59", 59);


        System.out.println(timeStamp.getValue("aaa", 2));

    }

    Map<String, Pair> map;

    public TimeStamp() {
        map = new HashMap<>();
    }

    // Set TimeStamp data variables
    public boolean setValue(String key, String value, int timestamp) {

        if (map.containsKey(key)) {
            map.get(key).nesterMap.put(timestamp, value);
            map.get(key).timestamps.add(timestamp);
        } else {
            Map<Integer, String> newMap = new HashMap<>();
            newMap.put(timestamp, value);
            List<Integer> lst = new ArrayList<>();
            lst.add(timestamp);
            Pair pair = new Pair(newMap, lst);
            map.put(key, pair);
        }
        return true;
    }

    // Get the value for the given key and timestamp
    public String getValue(String key, int timeStamp) {
        if (!map.containsKey(key)) return "";

        Pair pair = map.get(key);
        Map<Integer, String> map = pair.nesterMap;
        if (map.containsKey(timeStamp)) {
            return map.get(timeStamp);
        } else {
            int tmstp = searchTimeStamp(timeStamp, pair.timestamps);
            if (tmstp == -1) return "";
            return map.get(tmstp);
        }

    }

    private int searchTimeStamp(int timeStamp, List<Integer> timestamps) {
        int len = timestamps.size();
        int left = 0;
        int right = len-1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (timestamps.get(mid) > timeStamp) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        if (left-1 < 0) return -1;

        return timestamps.get(left-1);
    }
}


class Pair {
    Map<Integer, String> nesterMap;
    List<Integer> timestamps;

    public Pair(Map<Integer, String> nesterMap, List<Integer> timestamps) {
        this.nesterMap = nesterMap;
        this.timestamps = timestamps;
    }


}
