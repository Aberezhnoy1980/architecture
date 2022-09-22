package ru.aberezhnoy.chain_of_responsibility;

/* заметки для себя
    1. TODO Нужно понять и аргументировать что использовать: простую фабрику, абстрактную или фабричный метод.
    2. Инкапсуляцию я реализовал (в примере на PHP, дочерние классы просто напрямую используют методы с реализацией абстрактного родителя:
 * запер супер-класс и наследников в private-package, на супер повесил интерфейс.
 * Разобрался как не переопределяя методы с реализацией супер-класса использовать
 * напрямую в дочерних через super: для этого необходимо в абстрактном супер-классе
 * сделать параметризованный конструктор и переопределить его (неявно) в дочерних.
 * Соответственно свои поля в дочерних тогда не нужны. Вопрос нужен ли тогда
 * абстрактный класс без абстрактных методов в данном примере, а по жизни можно
 * комбинировать, например. */

public class ChainOsResponsibilityApp {
    public static void main(String[] args) throws Exception {

        // instances create through a simple factory by class name switching
        Account bank = AccountFactory.create("Bank", 200f);
        Account paypal = AccountFactory.create("Paypal", 300f);
        Account bitcoin = AccountFactory.create("Bitcoin", 400f);
        Account pocket = AccountFactory.create("Pocket", 50f);

        // chain build
        pocket.setNext(bank);
        bank.setNext(paypal);
        paypal.setNext(bitcoin);

        // input argument initialization
        var sum = 359f;

        // Check instances creation
        System.out.println(bank.getClass().getSimpleName());
        bank.checkBalance();
        System.out.println(bank.getBalance());
        System.out.println(bank.canPay(sum));
        System.out.println();

        System.out.println(paypal.getClass().getSimpleName());
        paypal.checkBalance();
        System.out.println(paypal.getBalance());
        System.out.println(paypal.canPay(sum));
        System.out.println();

        System.out.println(bitcoin.getClass().getSimpleName());
        bitcoin.checkBalance();
        System.out.println(bitcoin.getBalance());
        System.out.println(bitcoin.canPay(sum));
        System.out.println();

        System.out.println(pocket.getClass().getSimpleName());
        pocket.checkBalance();
        pocket.extBalance(2);
        System.out.println(pocket.getBalance());
        System.out.println(pocket.canPay(sum));
        System.out.println();

        // test app
        pocket.pay(sum);
    }
}
