package com.meritamerica.assignment3;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		//MeritBank.readFromFile("src/test/testMeritBank_good.txt");
	CDOffering text = CDOffering.readFromString("1,0.01");
	
	System.out.println(text.writeToString());
	}
}