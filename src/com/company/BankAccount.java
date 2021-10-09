package com.company;

public class BankAccount extends LimitException{

    private double amount;

    public BankAccount(String message, double remainingAmount) {
        super(message, remainingAmount);
    }

    public void deposit(double sum) {
        amount = amount + sum;
    }

    public void withdraw(double sum) throws LimitException {
        if (sum > amount) {
            throw new LimitException("Запращиваемая сумма превышает баланс: ", getAmount());
        }
        this.amount = amount - sum;
    }

    public double getAmount() {
        return amount;
    }

}
