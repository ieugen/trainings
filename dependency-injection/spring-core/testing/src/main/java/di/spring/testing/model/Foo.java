package di.spring.testing.model;

public class Foo {

    private IBar iBar;

    public Foo(IBar iBar) {
        this.iBar = iBar;
    }

    public String printIt() {
        String result = iBar.doIt() + " from Foo";
        System.out.println(result);
        return result;
    }

}
