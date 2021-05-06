package com.meritamerica.assignment3;

public class BankAccount {

	private double balance;
	private double interestRate = 0;
	private long accountNumber;

	public BankAccount(double openingBalance, double interestRate) {
		accountNumber = MeritBank.getNextAccountNumber();
		balance = openingBalance;
		this.interestRate = interestRate;
	}

	public BankAccount(long accountNumber, double openingBalance, double interestRate) {
		this.accountNumber = accountNumber;
		balance = openingBalance;
		this.interestRate = interestRate;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}
	
	boolean withdraw(double amount) {
		if (amount < 0 || amount > balance) {
			return false;
		}
		balance -= amount;
		return true;
	}

	boolean deposit(double amount) {
		if (amount < 0) {
			return false;
		}
		balance += amount;
		return true;
	}

	double futureValue(int years) {
		return balance * Math.pow(1 + interestRate, years);
	}

	@Override
	public String toString() {
		return "\nChecking Account Balance: $" + String.format("%.2f", this.getBalance())
				+ "\nChecking Account Interest Rate: " + String.format("%.4f", this.getInterestRate())
				+ "\nChecking Account Balance in 3 years: " + String.format("%.2f", this.futureValue(3));
	}
}
