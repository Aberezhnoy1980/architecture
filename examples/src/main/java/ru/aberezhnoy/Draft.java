package ru.aberezhnoy;

import ru.aberezhnoy.chain_of_responsibility.Account;
import ru.aberezhnoy.chain_of_responsibility.AccountFactory;

public class Draft {
    public static void main(String[] args) throws Exception {

        Account bank = AccountFactory.create("Bank", 200f);
        Account paypal = AccountFactory.create("Paypal", 300f);
        Account bitcoin = AccountFactory.create("Bitcoin", 400f);
        Account pocket = AccountFactory.create("Pocket", 50f);

        pocket.setNext(bank);
        bank.setNext(paypal);
        paypal.setNext(bitcoin);

        var sum = 359f;

        System.out.println(bank.getClass().getSimpleName());
        bank.checkBalance();
        System.out.println(bank.getBalance());
        System.out.println(bank.canPay(sum));
//        bank.pay(259f);
        System.out.println();

        System.out.println(paypal.getClass().getSimpleName());
        paypal.checkBalance();
        System.out.println(paypal.getBalance());
        System.out.println(paypal.canPay(sum));
//        paypal.pay(259f);
        System.out.println();

        System.out.println(bitcoin.getClass().getSimpleName());
        bitcoin.checkBalance();
        System.out.println(bitcoin.getBalance());
        System.out.println(bitcoin.canPay(sum));
//        bitcoin.pay(259f);
        System.out.println();

        System.out.println(pocket.getClass().getSimpleName());
        pocket.checkBalance();
        pocket.extBalance(2);
        System.out.println(pocket.getBalance());
        System.out.println(pocket.canPay(sum));
//        pocket.pay(259f);
        System.out.println();

        pocket.pay(sum);
    }
}
