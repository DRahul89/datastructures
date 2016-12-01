package main.java.hashtable;

public class HashKey {
	private static final int MOD = 7;
	private int key;

	public HashKey(final int key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		return key % MOD;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashKey other = (HashKey) obj;
		if (key != other.key)
			return false;
		return true;
	}

}
