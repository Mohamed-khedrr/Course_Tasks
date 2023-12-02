package org.example;

public class InterestAccount extends BankSystem implements InterestCalculator {
    private double interesRate ;
    public InterestAccount(String customerName , String accountNumber , double accountBalance, double interesRate){
    super(customerName, accountNumber , accountBalance);
    this.interesRate = interesRate ;
    }

    @Override
    public double calculateInterest() {
        return this.getAccountBalance() * this.interesRate / 100;
    }
}
