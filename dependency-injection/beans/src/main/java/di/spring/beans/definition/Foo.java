package di.spring.beans.definition;

import java.beans.ConstructorProperties;

public class Foo {

    private String a;
    private int b;
    private String c;

    public Foo(String a) {
        this.a = a;
    }

    // http://docs.oracle.com/javase/6/docs/api/java/beans/ConstructorProperties.html
    @ConstructorProperties({"a","b","c"})
    public Foo(String a, int b, String c){

    }

    public void init() {
        c = a + b;
    }

    public void destroy() {
        c = null;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
