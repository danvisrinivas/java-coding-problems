package general_programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortingMap {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("z", 30);
		map.put("a", 20);
		map.put("c", 1);
		
		map.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey()).
				collect(Collectors.toMap(Map.Entry::getKey,
				Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

		map.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.
						toMap(Map.Entry::getKey,Map.Entry::getValue,
								(oldvalue, newvalue) -> oldvalue, LinkedHashMap::new));


		//System.out.println(sortedMap);
		
		/**
		 * Another way before  java 8 version
		 */
		
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		for(Map.Entry<String, Integer> m:  list){
			System.out.println(m.getKey() + "," + m.getValue());
		}
		
	}

}
