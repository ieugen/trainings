package di.spring.config;

import di.spring.config.java.Bar;

public class BarFactory {

    private Bar bar = new Bar();

    public static Bar staticMakeBar() {
        return new Bar();
    }

    public Bar instanceMakeBar() {
        return bar;
    }
}
