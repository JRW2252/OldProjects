import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimaps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jameswilliams on 10/25/16.
 */
public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(4, "c");
        map.put(5, "d");
        map.put(5, "a");
        map.put(6, "b");
        map.put(7, "c");
        map.put(8, "d");
        map.put(9, "e");
        System.out.println("Map: " + map);
        HashMultimap<String, Integer> multimap = Multimaps.invertFrom(Multimaps.forMap(map),
                HashMultimap.<String, Integer>create());

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            multimap.put(entry.getValue(), entry.getKey());
        }

        System.out.println("");
        for (Map.Entry<String, Collection<Integer>> entry : multimap.asMap().entrySet()) {
            System.out.println("Value: " + entry.getKey() + " => keys: " + entry.getValue());
        }
    }
}
/*          OUTPUT
* Map: {1=a, 2=b, 4=c, 5=a, 6=b, 7=c, 8=d, 9=e}
*
* Value: a => keys: [1, 5]
* Value: b => keys: [2, 6]
* Value: c => keys: [4, 7]
* Value: d => keys: [8]
* Value: e => keys: [9]
* */