/*
package week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javafx.util.Pair;

public class TimeMap {
    HashMap<String,List<Object[]>> map = new HashMap<>();
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        HashMap<String,Object[]> val = map.getOrDefault(key,new HashMap<>());
        val.put(value,timestamp);
        map.put(key,val);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        HashMap<String,Integer> mapAtKey = map.get(key);
        List<Integer> timestamps = new ArrayList<>(mapAtKey.values());


    }

}
*/
