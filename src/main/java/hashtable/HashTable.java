package main.java.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a hash table structure
 * 
 * 
 *
 */
public class HashTable<E, V> {

	private int tableSize;

	private int totalElement;

	private HashTableNode<E, V>[] listNodes;

	@SuppressWarnings("unchecked")
	public HashTable(final int size) {
		this.tableSize = size;
		this.listNodes = (HashTableNode<E, V>[]) new Object[tableSize];
	}

	public int getTableSize() {
		return tableSize;
	}

	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}

	public int getTotalElement() {
		return totalElement;
	}

	public void setTotalElement(int totalElement) {
		this.totalElement = totalElement;
	}

	public HashTableNode<E, V>[] getListNodes() {
		return listNodes;
	}

	public void setListNodes(HashTableNode<E, V>[] listNodes) {
		this.listNodes = listNodes;
	}

	public void hashInsert(final E key, final V data) {
		int hashCode = (int) key.hashCode();
		ListNode<E, V> listNode = new ListNode<E, V>(key, data);
		HashTableNode<E, V> hashTableNode = this.getListNodes()[hashCode];
		listNode.setNextNode(hashTableNode.getHeadNode());
		hashTableNode.setHeadNode(listNode);
		hashTableNode.setBucketCount(hashTableNode.getBucketCount() + 1);
		this.setTableSize(this.getTableSize() + 1);

	}

	public V searchHashTableData(final E key) {
		V data = null;
		int hashCode = (int) key.hashCode();
		HashTableNode<E, V> hashTableNode = this.getListNodes()[hashCode];
		ListNode<E, V> headNode = hashTableNode.getHeadNode();
		ListNode<E, V> tempNode = headNode;
		while (null != tempNode) {
			if (tempNode.equals(key)) {
				data = tempNode.getData();
				System.out.println();
				break;
			}
			tempNode = tempNode.getNextNode();
		}
		return data;
	}

}
