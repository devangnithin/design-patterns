package com.dghanwat.factory;

public class CurrencyFactory {

	public static Currency createCurrency(String country) {
		if (country.equalsIgnoreCase("UK")) {
			return new Pound();
		} else if (country.equalsIgnoreCase("US")) {
			return new USDollar();
		}
		throw new IllegalArgumentException("No such currency");
	}
}
