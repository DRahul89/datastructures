package main.java.hashtable;

public class HashTableDemo {
	public static void main(String[] args) {
		HashKey key = new HashKey(10);
		HashTable<HashKey, String> hashTable = new HashTable<HashKey, String>(50);
		hashTable.hashInsert(key, "my name");
		System.out.println(hashTable.searchHashTableData(key));
	}

}
