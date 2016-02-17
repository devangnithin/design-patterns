package com.dghanwat.facade;

public class FacadePattern {
	interface Worker {
		String work(String request);
	}

	static class RedWireBreaker implements Worker {

		public String work(String request) {
			return "Cut Red Wire";
		}
	}

	static class BlueWireBreaker implements Worker {

		public String work(String request) {
			return "Cut Blue Wire";
		}
	}

	static class YellowWireBreaker implements Worker {

		public String work(String request) {
			return "Cut Yellow Wire";
		}
	}

	static class Facade {

		RedWireBreaker redWireBreaker = new RedWireBreaker();
		BlueWireBreaker blueWireBreaker = new BlueWireBreaker();
		YellowWireBreaker yellowWireBreaker = new YellowWireBreaker();

		public String diffuseBomb(String request) {
			redWireBreaker.work(request);
			yellowWireBreaker.work(request);
			blueWireBreaker.work(request);

			return "work done";
		}
	}

	public static void main(String[] args) {
		String request = args[0];
		Facade facade = new Facade();
		facade.diffuseBomb(request);

	}
}
