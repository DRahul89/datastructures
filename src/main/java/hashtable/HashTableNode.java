package main.java.hashtable;

/**
 * 
 * This class will work as a Hash table Node
 *
 * @param <E>
 */
public class HashTableNode<E, V> {

	private int bucketCount;

	private ListNode<E, V> headNode;

	public HashTableNode() {
		// TODO Auto-generated constructor stub
	}

	public int getBucketCount() {
		return bucketCount;
	}

	public void setBucketCount(int bucketCount) {
		this.bucketCount = bucketCount;
	}

	public ListNode<E, V> getHeadNode() {
		return headNode;
	}

	public void setHeadNode(ListNode<E, V> headNode) {
		this.headNode = headNode;
	}

}
