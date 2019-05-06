package com.priceminister.account.implementation;

import com.priceminister.account.Account;
import com.priceminister.account.AccountRule;
import com.priceminister.account.IllegalBalanceException;

public class CustomerAccount implements Account {

	private Double balance;

	public CustomerAccount() {

		this.balance = 0.0;

	}

	public void add(Double addedAmount) {
		// TODO Auto-generated method stub

		balance = balance + addedAmount;
	}

	public void withdraw(Double withdrawnAmount) {
		// TODO Auto-generated method stub

		balance = balance - withdrawnAmount;
	}

	public Double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) throws IllegalBalanceException {
		// TODO Auto-generated method stub

		balance = balance - withdrawnAmount;

		if (rule.withdrawPermitted(balance) == true) {

		} else {

			throw new IllegalBalanceException(balance);

		}

		return balance;
	}

}
