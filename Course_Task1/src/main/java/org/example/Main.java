package org.example;

public class Main {
    public static void main(String[] args) {
        InterestAccount acc1 = new InterestAccount("Mohamed" ,"s1",1000,10) ;
        acc1.deposit(5000);
        acc1.withdraw(200);
        acc1.inquiryBalance();
        System.out.println(acc1.calculateInterest());
    }
}