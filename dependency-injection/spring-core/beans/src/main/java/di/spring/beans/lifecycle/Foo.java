package di.spring.beans.lifecycle;

public class Foo {

    private Bar bar;
    private Baz baz;

    public Foo() {
        System.out.println("Creating " + Foo.class.toString());
    }


    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public Baz getBaz() {
        return baz;
    }

    public void setBaz(Baz baz) {
        this.baz = baz;
    }
}
