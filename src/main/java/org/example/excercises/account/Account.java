package org.example.excercises.account;


public class Account{
    private int saldo = 0;


    public void depositFunds(int quantity) {
        saldo += quantity;
    }

    public int getSaldo() {
        return saldo;
    }
}
