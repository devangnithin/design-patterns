package com.dghanwat.cor;

public class ChainOfResponsibilityPattern {

	interface Chain {

		void setNext(Chain nextInChain);

		void process(Number request);
	}

	static class Number {
		private int number;

		public Number(int number) {
			this.number = number;
		}

		public int getNumber() {
			return number;
		}
	}

	static class NegativeProcessor implements Chain {

		private Chain nextInChain;

		public void setNext(Chain c) {
			nextInChain = c;
		}

		public void process(Number request) {
			if (request.getNumber() < 0) {
				System.out
						.println("NegativeProcessor : " + request.getNumber());
			} else {
				nextInChain.process(request);
			}
		}
	}

	static class ZeroProcessor implements Chain {

		private Chain nextInChain;

		public void setNext(Chain c) {
			nextInChain = c;
		}

		public void process(Number request) {
			if (request.getNumber() == 0) {
				System.out.println("ZeroProcessor : " + request.getNumber());
			} else {
				nextInChain.process(request);
			}
		}
	}

	static class PositiveProcessor implements Chain {

		private Chain nextInChain;

		public void setNext(Chain c) {
			nextInChain = c;
		}

		public void process(Number request) {
			if (request.getNumber() > 0) {
				System.out
						.println("PositiveProcessor : " + request.getNumber());
			} else {
				nextInChain.process(request);
			}
		}
	}

	public static void main(String[] args) {
		// configure Chain of Responsibility
		Chain c1 = new NegativeProcessor();
		Chain c2 = new ZeroProcessor();
		Chain c3 = new PositiveProcessor();
		c1.setNext(c2);
		c2.setNext(c3);

		// calling chain of responsibility
		c1.process(new Number(99));
		c1.process(new Number(-30));
		c1.process(new Number(0));
		c1.process(new Number(100));
	}
}
