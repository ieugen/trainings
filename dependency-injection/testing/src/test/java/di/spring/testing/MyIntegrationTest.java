package di.spring.testing;

import di.spring.testing.model.Foo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, IntegrationTestConfig.class})
@ActiveProfiles("dev")
public class MyIntegrationTest {

    @Autowired
    private Foo foo;

    @Test
    public void testApplicationStarts() throws Exception {
        String result = foo.printIt();

        assertThat(result, containsString("Profilul DEV"));
    }
}
