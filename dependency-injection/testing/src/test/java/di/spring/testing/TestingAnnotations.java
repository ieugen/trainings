package di.spring.testing;

import di.spring.testing.model.Foo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, IntegrationTestConfig.class})
@ActiveProfiles("dev")
public class TestingAnnotations {

    @Autowired
    private Foo foo;

    @Test
    @Repeat(value = 10)
    public void testRepeatThisTest_10_Times() throws Exception {
        foo.printIt();
    }

    @Test
    @IfProfileValue(name = "my.java", value = "openjdk")
    public void testIfProfileValue() throws Exception {
        System.out.println("This test will execute only if System Property 'my.java' is 'openjdk' ");
    }

    @Test
    @Timed(millis = 10)
    public void testTimedExecution() throws Exception {
        System.out.println("Will fail if method takes longer than 10 millis. " +
                "Will wait for it to finish, unlike JUnit timeout");

//        java.util.concurrent.TimeUnit.MILLISECONDS.sleep(15);

    }
}
