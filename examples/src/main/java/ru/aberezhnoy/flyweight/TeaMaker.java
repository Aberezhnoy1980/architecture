package ru.aberezhnoy.flyweight;

import java.util.EnumMap;
import java.util.Map;

public class TeaMaker {

    private final Map<TeaType, Tea> teas;

    public TeaMaker() {
        teas = new EnumMap<>(TeaType.class);
    }

    public static TeaMaker newTeaMaker() {
        return new TeaMaker();
    }

    public Tea make(TeaType type) {
        var tea = teas.get(type);
        if (tea == null) {
            switch (type) {
                case KARAK:
                    tea = new KarakTea("karak");
                    teas.put(type, tea);
                    break;
                case MASALA:
                    tea = new MasalaTea("masala");
                    teas.put(type, tea);
                    break;
                default:
                    break;
            }
        }
        return tea;
    }
}
