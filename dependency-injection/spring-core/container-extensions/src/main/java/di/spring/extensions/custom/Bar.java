package di.spring.extensions.custom;

public class Bar implements IBar {

    private int a;

    public Bar() {
        this(0);
    }

    public Bar(int a) {
        this.a = a;
    }

    public void printIt() {
        System.out.println("We have value " + a);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
