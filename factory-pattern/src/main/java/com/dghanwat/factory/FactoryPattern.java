package com.dghanwat.factory;

public class FactoryPattern {
	interface Currency {
		String getSymbol();
	}

	static class Pound implements Currency {

		public String getSymbol() {
			return "GBP";
		}

	}

	static class USDollar implements Currency {

		public String getSymbol() {
			return "$";
		}
	}

	public static class CurrencyFactory {

		public Currency createCurrency(String country) {
			if (country.equalsIgnoreCase("UK")) {
				return new Pound();
			} else if (country.equalsIgnoreCase("US")) {
				return new USDollar();
			}
			throw new IllegalArgumentException("No such currency");
		}
	}

	public static void main(String[] args) {
		CurrencyFactory factory = new CurrencyFactory();
		Currency currency = factory.createCurrency("UK");
		System.out.println(currency.getSymbol());

	}
}
