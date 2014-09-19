package di.spring.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = IntegrationTestConfig.class)
@TestPropertySource(
        locations = {"classpath:/test.properties"},
        properties = {"my.int = 10", "my.string = hello"})
public class PropertyLoadingTest {

    @Autowired
    private Environment environment;

    @Test
    public void testPropertyLoading() throws Exception {
        assertThat(environment.getProperty("my.test.property"), containsString("We can do Spring Testing"));

        assertThat(environment.getProperty("my.int"), containsString("10"));
    }
}
