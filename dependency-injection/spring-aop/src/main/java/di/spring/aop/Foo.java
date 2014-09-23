package di.spring.aop;

public class Foo {

    public String methodCall(String name, int count) {
        return name + count;
    }

    void testAop(){
        System.out.println("aaaa");
    }
}
