package ru.aberezhnoy.flyweight;

public class Order {

    private final TeaType teaType;

    private final int tableNumber;

    public Order(TeaType teaType, int tableNumber) {
        this.teaType = teaType;
        this.tableNumber = tableNumber;
    }

    public static Order newOrder(TeaType teaType, int tableNumber) {
        return new Order(teaType, tableNumber);
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public TeaType getTeaType() {
        return teaType;
    }
}
