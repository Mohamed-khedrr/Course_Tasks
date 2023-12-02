package org.example;

public class BankSystem {
    private String customerName ;
    private String accountNumber ;
    private double accountBalance ;

    public BankSystem(String customerName , String accountNumber , double accountBalance){
        this.accountBalance = accountBalance ;
        this.accountNumber = accountNumber ;
        this.customerName = customerName ;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void deposit(double amount){
    this.accountBalance += amount ;
    }

    public void withdraw(double amount){
        if(amount > 0 && this.accountBalance >= amount)
            this.accountBalance -= amount ;
        else
            System.out.println("Invalid Amount") ;
    }


    public void  inquiryBalance(){
        System.out.println("Your Current Balance is : "+ this.accountBalance);
    }



}
