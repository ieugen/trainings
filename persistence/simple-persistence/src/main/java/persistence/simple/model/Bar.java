package persistence.simple.model;

import java.io.Serializable;

public class Bar implements Serializable {

    private int count;
    private String text;

    public Bar() {
        this(0, null);
    }

    public Bar(int count, String text) {
        this.count = count;
        this.text = text;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "count=" + count +
                ", text='" + text + '\'' +
                '}';
    }
}
