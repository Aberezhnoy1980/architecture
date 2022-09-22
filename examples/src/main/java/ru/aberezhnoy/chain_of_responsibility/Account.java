package ru.aberezhnoy.chain_of_responsibility;

public interface Account {

    void setNext(Account account);

    void pay(float amountToPay) throws Exception;

    boolean canPay(float amountToPay);

    void checkBalance();

    void extBalance(float kft);

    float getBalance();
}
