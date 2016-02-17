package com.dghanwat.command;

import java.util.HashMap;
import java.util.Map;

public class CommandPattern {

	interface Command {
		void execute(String request);
	}

	static class DomesticHelper implements Command {
		public void execute(String request) {
			System.out.println("take out the trash");
		}
	}

	static class Politician implements Command {
		public void execute(String request) {
			System.out
					.println("take money from the rich, take votes from the poor");
		}
	}

	static class Programmer implements Command {
		public void execute(String request) {
			System.out.println("sell the bugs, charge extra for the fixes");
		}
	}

	public static Map<String, Command> produceCommandMap() {
		Map<String, Command> commandMap = new HashMap<String, Command>();
		commandMap.put("de", new DomesticHelper());
		commandMap.put("p", new Politician());
		commandMap.put("pr", new Programmer());
		return commandMap;
	}

	public static void main(String[] args) {
		Map<String, Command> commandMap = produceCommandMap();
		String key = args[0];
		String request = args[1];

		Command command = commandMap.get(key);
		command.execute(request);
	}
}
