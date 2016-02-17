package com.dghanwat.factory;

public class Main {

	public static void main(String[] args) {
		Currency currency = CurrencyFactory.createCurrency("UK");
		System.out.println(currency.getSymbol());

	}

}
