package com.meritamerica.assignment3;

public class CheckingAccount extends BankAccount {

	private final static double INTEREST_RATE = 0.0001;
	
	public CheckingAccount(double openingBalance) {
		super(openingBalance, INTEREST_RATE);
	}
}
