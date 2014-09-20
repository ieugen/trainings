package persistence.simple.spring;

import org.hamcrest.core.StringContains;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import persistence.simple.spring.model.Settings;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:serialization.xml")
public class SettingsOxmSerializationTest {

    private Settings settings;

    @Autowired
    private Marshaller marshaller;

    @Autowired
    private Unmarshaller unmarshaller;

    @Before
    public void setUp() throws Exception {
        settings = new Settings();
        settings.setMessage("Hello OXM");
        settings.setFooEnabled(true);
    }

    @Test
    public void testMarshallSettings() throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        marshaller.marshal(settings, new StreamResult(bos));

        String result = bos.toString("UTF-8");
        System.out.println(result);

        assertThat(result, StringContains.containsString("<?xml"));
        assertThat(result, StringContains.containsString("<message>Hello OXM</message>"));
    }

    @Test
    public void testUnmarshallSettings() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<settings>" +
                "<fooEnabled>true</fooEnabled>" +
                "<message>Hello OXM</message>" +
                "</settings>";

        Settings result = (Settings) unmarshaller.unmarshal(new StreamSource(new StringReader(xml)));

        assertThat(result.getMessage(), is("Hello OXM"));
        assertThat(result.isFooEnabled(), is(true));
    }
}
