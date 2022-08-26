package ru.aberezhnoy.dekorator;

public class DecoratorApp {

    public static void main(String[] args) {

        Coffee someCoffee = new SimpleCoffee();
        System.out.println(someCoffee.getCost() + "\n" + someCoffee.getDescription()); // 10 \n Simple coffee

        someCoffee = new MilkCoffee(someCoffee);
        System.out.println(someCoffee.getCost() + "\n" + someCoffee.getDescription()); // 12 \n Simple coffee, milk

        someCoffee = new WhipCoffee(someCoffee);
        System.out.println(someCoffee.getCost() + "\n" + someCoffee.getDescription()); // 17 \n Simple coffee, milk, whip

        someCoffee = new VanillaCoffee(someCoffee);
        System.out.println(someCoffee.getCost() + "\n" + someCoffee.getDescription()); // 20 \n Simple coffee, milk, whip, vanilla
    }
}
