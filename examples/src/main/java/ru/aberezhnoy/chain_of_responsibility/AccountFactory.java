package ru.aberezhnoy.chain_of_responsibility;

public final class AccountFactory {

    public static Account create(String type, float balance) {

        switch (type) {
            case "Bank":
                return new Bank(balance);
            case "Paypal":
                return new Paypal(balance);
            case "Bitcoin":
                return new Bitcoin(balance);
            case "Pocket":
                return new Pocket(balance);
            default:
                throw new IllegalStateException("Account not found");
        }
    }
}
