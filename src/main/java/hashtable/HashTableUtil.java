package main.java.hashtable;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * This class contain the operation for hash table
 *
 */
public class HashTableUtil<E, V> {

	private static final int LOAD_FACTOR = 2;

	public HashTable<E, V> createHashTable(final int size) {
		HashTable<E, V> hashTable = new HashTable<E, V>(size / LOAD_FACTOR);
		hashTable.setListNodes(new ArrayList<HashTableNode<E, V>>());
		for (int i = 0; i < size; i++) {
			HashTableNode<E, V> haNode = new HashTableNode<E, V>();
			hashTable.getListNodes().set(i, haNode);
		}
		return hashTable;
	}


}
