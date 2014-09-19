package di.spring.beans.lifecycle;

public class FooCustomMethods implements Foo {

    private Bar bar;
    private Baz baz;

    public FooCustomMethods() {
        System.out.println(getClass().getSimpleName() + " created");
    }

    public void customInit() {
        System.out.println(getClass().getSimpleName() + " init method called");
    }

    public void customDestroy() {
        System.out.println(getClass().getSimpleName() + " destroy method called" );
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
