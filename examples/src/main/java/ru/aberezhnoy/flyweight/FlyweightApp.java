package ru.aberezhnoy.flyweight;

public class FlyweightApp {

    public static void main(String[] args) {

//    TeaMaker teaMaker = TeaMaker.newTeaMaker();
//
//    TeaShop teaShop = TeaShop.newTeaShop(teaMaker);

        TeaShop teaShop = TeaShop
                .newTeaShop(TeaMaker
                        .newTeaMaker());

//    teaShop.takeOrder(TeaType.KARAK, 1);
//    teaShop.takeOrder(TeaType.MASALA, 14);
        teaShop.takeOrder(Order.newOrder(TeaType.MASALA, 1));
        teaShop.takeOrder(Order.newOrder(TeaType.MASALA, 1));
        teaShop.takeOrder(Order.newOrder(TeaType.KARAK, 18));
        teaShop.takeOrder(Order.newOrder(TeaType.KARAK, 1));

        teaShop.serve();
    }
}
