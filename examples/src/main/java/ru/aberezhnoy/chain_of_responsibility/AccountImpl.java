package ru.aberezhnoy.chain_of_responsibility;

abstract class AccountImpl implements Account {
    private Account successor;
    private float balance;

    public AccountImpl(float balance) {
        this.balance = balance;
    }

    @Override
    public void setNext(Account account) {
        this.successor = account;
    }

    @Override
    public float getBalance() {
        return balance;
    }

    @Override
    public void pay(float amountToPay) throws Exception {
        if (this.canPay(amountToPay)) {
            System.out.printf("Paid %s using %s\n", amountToPay, getClass().getSimpleName());
            System.out.println("New balance:" + (this.balance - amountToPay));
        } else if (this.successor == null) {
            throw new Exception("None of the accounts have enough balance\n");
        } else {
            System.out.printf("Cannot pay using %s. Proceeding ..\n", getClass().getSimpleName());
            this.successor.pay(amountToPay);
        }
    }

    @Override
    public boolean canPay(float amountToPay) {
        return this.balance >= amountToPay;
    }

    @Override
    public void checkBalance() {
        System.out.println(this.balance);
    }

    @Override
    public void extBalance(float kft) {
        this.balance *= kft;
    }
}








