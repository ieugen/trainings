package persistence.simple.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Foo implements Serializable {

    private int count;

    List<Bar> bars;

    public Foo() {
        this(0, new ArrayList<Bar>());
    }

    public Foo(int count, List<Bar> bars) {
        this.count = count;
        this.bars = bars;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Bar> getBars() {
        return bars;
    }

    public void setBars(List<Bar> bars) {
        this.bars = bars;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "count=" + count +
                ", bars=" + bars +
                '}';
    }
}
