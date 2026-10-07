package org.example.excercises.account;

public class Deposit implements Runnable {
    private Account account;

    public Deposit(Account account) {
        this.account = account;
    }

    @Override
    public void run(){
        account.depositFunds(1);
    }
}
