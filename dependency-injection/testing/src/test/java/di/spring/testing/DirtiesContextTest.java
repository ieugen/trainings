package di.spring.testing;

import di.spring.testing.model.DevBar;
import di.spring.testing.model.IBar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DirtiesContextTest {

    @Autowired
    DevBar iBar;

    @Test
    public void testToMakeContextDirty() throws Exception {
        iBar.doIt();
        assertThat(iBar.doIt(), is("Profilul DEV este activ."));
        // dirty the context
        iBar.setMessage("This is a dirty message. It dirties the context.");
    }

    @Test
    public void testToMakeContextDirtyX() throws Exception {
        iBar.doIt();

        assertThat(iBar.doIt(), is("Profilul DEV este activ."));
    }

    @Configuration
    public static class Config {

        @Bean
        public IBar iBar() {
            return new DevBar();
        }
    }
}
