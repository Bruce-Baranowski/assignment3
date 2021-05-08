package com.meritamerica.assignment3;

import java.util.Arrays;
import java.util.Random;

public class MeritBank {
	
	private static AccountHolder[] accounts = new AccountHolder[0];
	private static CDOffering[] cdOfferings;
	private static long nextAccountNumber = 1;
	
	public static void addAccountHolder(AccountHolder accountHolder) {
		AccountHolder[] tmp = new AccountHolder[accounts.length+1];
		for (int i = 0; i<accounts.length; i++) {
			tmp[i] = accounts[i];
		}
		tmp[accounts.length] = accountHolder;
		accounts = tmp;
	}
	
	public static AccountHolder[] getAccountHolders() {
		return accounts;
	}
	
	public static CDOffering[] getCDOfferings() {
		return cdOfferings;
	}


	public static CDOffering getBestCDOffering(double depositAmount) {
		CDOffering bestOffer = null;
		double highestResult = 0;
		if (cdOfferings!=null) {
			for (CDOffering x: cdOfferings) {
				double xFutureValue = futureValue(depositAmount, x.getInterestRate(), x.getTerm());
				if (xFutureValue > highestResult) {
					highestResult = xFutureValue;
					bestOffer = x;
				}
			}
		}
		return bestOffer;
	}
	
	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		CDOffering bestOffer = null;
		CDOffering secondBestOffer = null;
		double highestResult = 0;
		double secondHighestResult = 0;
		if (cdOfferings!=null) {
			for (CDOffering x: cdOfferings) {
				double xFutureValue = futureValue(depositAmount, x.getInterestRate(), x.getTerm());
				if (xFutureValue > highestResult) {
					secondHighestResult = highestResult;
					highestResult = xFutureValue;
					secondBestOffer = bestOffer;
					bestOffer = x;
					
				}
				else if (xFutureValue > secondHighestResult) {
					secondHighestResult = xFutureValue;
					secondBestOffer = x;
				}
			}
		}
		return secondBestOffer;
	}

	
	public static void setCDOfferings(CDOffering[] cdOfferings) {
		MeritBank.cdOfferings = cdOfferings;
	}
	
	public static void clearCDOfferings() {
		MeritBank.cdOfferings = null;
	}
	
	public static long getNextAccountNumber() {
		return nextAccountNumber++;
	}
	
	public static void setNextAccountNumber(long nextAccountNumber) {
		MeritBank.nextAccountNumber = nextAccountNumber;
	}
	public static AccountHolder[] sortAccountHolders() {
		java.util.Arrays.sort(accounts);
		return accounts;
		
	}
	public static double totalBalances() {
		double total = 0;
		for (AccountHolder x: accounts) {
			total += x.getCombinedBalance();
		}
		return total;
	}

	public static double futureValue(double presentValue, double interestRate, int term) {
		return presentValue * Math.pow(1 + interestRate, term);
	}
}
