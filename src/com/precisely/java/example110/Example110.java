package com.precisely.java.example110;// Example 110 from page 83 of Java Precisely third edition (The MIT Press 2016)
// Author: Peter Sestoft (sestoft@itu.dk)

import com.precisely.java.example109.Util;

class Bank {
    private int account1 = 10, account2 = 20;

    synchronized public void transfer(int amount) {
        int new1 = account1 - amount;
        Util.pause(10);
        account1 = new1;
        account2 = account2 + amount;
        System.out.println("Sum is " + (account1 + account2));
    }
}

class Clerk extends Thread {
    private final Bank bank;

    public Clerk(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        for (; ; ) {                                  // Forever
            bank.transfer(Util.random(-10, 10));      //   transfer money
            Util.pause(200, 300);                     //   then take a break
        }
    }
}

class Example110 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        new Clerk(bank).start();
        new Clerk(bank).start();
    }
}
