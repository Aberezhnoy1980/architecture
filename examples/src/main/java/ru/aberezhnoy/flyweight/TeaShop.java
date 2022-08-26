package ru.aberezhnoy.flyweight;

import java.util.*;

public class TeaShop {

    private final TeaMaker teaMaker;

//    private final Map<Tea, Integer> orders = new HashMap<>();
    private final List<Order> orders = new ArrayList<>();

    public TeaShop(TeaMaker teaMaker) {
        this.teaMaker = teaMaker;
    }

    public static TeaShop newTeaShop(TeaMaker teaMaker) {
        return new TeaShop(teaMaker);
    }

//    public void takeOrder(TeaType teaType, int table) {
//        orders.put(teaMaker.make(teaType), table);
//    }
//
    public void takeOrder(Order order) {
        orders.add(order);
    }

    public void ordersList() {
        System.out.println(orders);

    }

//    public void serve() {
//        for (Map.Entry<Tea, Integer> entry : orders.entrySet()) {
//            System.out.println("Serving " + entry.getKey() + " to table#" + entry.getValue());
//        }

        public void serve() {
        for (Order o : orders) {
            System.out.println("Serving " + teaMaker.make(o.getTeaType()) + " to table#" + o.getTableNumber());
        }
    }
}










