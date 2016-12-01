package main.java.concurrency.concurrentapi.concurrentmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 
 * A class contains example of concurrent maps
 *
 */
public class ConcurrentMapExample {

	
	private static ConcurrentMap<String,String> concurrentMap = null;
	
	private static ConcurrentNavigableMap<String,String> concurrentNavigableMap = null;
	
	public static void concurentHashMapExp(){
		concurrentMap = new ConcurrentHashMap<String, String>();
		concurrentMap.put("rahul","dixit");
		concurrentMap.putIfAbsent("rahul","shakti");
		System.out.println(concurrentMap.get("rahul"));
	}
	
	public static void concurentnavigableHashMapExp(){
		concurrentNavigableMap = new ConcurrentSkipListMap<String, String>();
		concurrentNavigableMap.put("1","dixit");
		concurrentNavigableMap.put("2","shakti");
		concurrentNavigableMap.put("3","rahul");
		ConcurrentNavigableMap<String,String> headMap = concurrentNavigableMap.headMap("2");
		ConcurrentNavigableMap<String,String> tailMap = concurrentNavigableMap.tailMap("2");
		ConcurrentNavigableMap<String,String> subMap = concurrentNavigableMap.subMap("2","3");
		
		System.out.println(headMap);
		System.out.println(tailMap);
		System.out.println(subMap);
	}
	
	public static void main(String[] args) {
		//concurentHashMapExp();
		concurentnavigableHashMapExp();
	}
}
