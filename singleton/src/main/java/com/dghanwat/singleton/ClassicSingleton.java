package com.dghanwat.singleton;

public class ClassicSingleton {
	private static ClassicSingleton instance = null;

	private ClassicSingleton() {
		// Exists only to defeat instantiation.
	}

	public synchronized static ClassicSingleton getInstance() {
		if (instance == null) {
			System.out.println("Creating new Instance");
			instance = new ClassicSingleton();
		} else {
			System.out.println("Reusing existing instance");
		}
		return instance;
	}

	public static void main(String[] args) throws Exception {

		ClassicSingleton.getInstance();
		int size = 5;
		do {
			Thread.sleep(1000);
			ClassicSingleton.getInstance();
		} while (--size > 0);
		

	}

}
