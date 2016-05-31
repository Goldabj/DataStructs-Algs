import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapKeySwap {

	
	public static void main(String[] args) {
//		Map<String, String> map = new HashMap<>();
//		
//		
//		map.put("A", "B");
//		map.put("C", "D");
//		map.put("E", "F");
//		System.out.println(map.toString());
//		map.put("A", "Z");
//		Map<String, String> map2 = valueKeySwap(map);
//		System.out.println(map2.toString());
		
//		stringobj();
		
		TreeSet set = new TreeSet();
		set.add(1);
		set.add(2);
		set.add(3);
		System.out.println(set.size() + "");
		set.add(3);
		System.out.println(set.size() + "");
		
		
	}

	public static Map<String, String> valueKeySwap(Map<String, String> map) {
		Set<String> keyset = map.keySet();
		Map<String, String> newMap = new HashMap<>();
		for(String key : keyset) {
			if(newMap.containsKey(key)) {
				System.out.println("error");
				//throw new Exception();
			}
			newMap.put(map.get(key), key);
		}
		
		return newMap;
		
	}
	
	public static void stringobj() {
		Object obj = new String("xyz");
		System.out.println(obj);
	}
}
