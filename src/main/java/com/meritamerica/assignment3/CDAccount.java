package com.meritamerica.assignment3;

import java.util.Date;

public class CDAccount extends BankAccount {
	
	private Date startDate;
	private int term;
	
	public CDAccount(CDOffering offering, double openingBalance) {
		super(openingBalance, offering.getInterestRate());
		term = offering.getTerm();
		startDate = new Date();
	}

	public Date getStartDate() {
		return startDate;
	}

	public int getTerm() {
		return term;
	}
	
	@Override
	public boolean deposit(double amount) {
		return false;
	}
	
	@Override
	public boolean withdraw(double amount) {
		return false;
	}
	
}
