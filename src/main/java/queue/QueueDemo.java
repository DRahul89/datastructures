package main.java.queue;

public class QueueDemo {

	public static void main(String[] args) {
		//arrayListDemo();
		linkedListDemo();
	}

	private static void linkedListDemo() {
		LLQueue<String> arr = new LLQueue<String>();
		for (int i = 0; i < 10; i++) {
			arr.enQueue("abc" + i);
		}
		for (int i = 0; i < 12; i++) {
			System.out.println("elements " + arr.deQueue());
		}

	}

	private static void arrayListDemo() {
		ArrayListQueue arr = new ArrayListQueue(10);
		for (int i = 0; i < 10; i++) {
			arr.enQueue(i);
		}
		for (int i = 0; i < 7; i++) {
			System.out.println("elements " + arr.deQueue());
		}
		System.out.println("size of queue " + arr.queueSize());
		for (int i = 0; i < 5; i++) {
			arr.enQueue(i);
		}
	}
}
