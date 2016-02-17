package com.dghanwat.delegate;

public class DelegatePattern {

	interface Worker {
		String work(String request);
	}

	static class Manager implements Worker {

		private TeamLead tl = new TeamLead();

		public String work(String request) {
			return tl.work(request); // Delegate to Team Lead
		}
	}

	static class TeamLead implements Worker {

		Worker developer = new Developer();

		public String work(String request) {
			return developer.work(request); // Delegate to Developer
		}

	}

	static class Developer implements Worker {

		public String work(String request) {
			return "Developer doing all the work";
		}

	}

	public static void main(String[] args) {
		String request = args[0];
		Manager manager = new Manager();
		manager.work(request);

	}
}
