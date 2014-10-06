package camel.blueprint.test;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Dictionary;

import static org.hamcrest.core.Is.is;

public class CamelBlueprintExampleTest extends CamelBlueprintTestSupport {

    @EndpointInject(uri = "mock:end")
    MockEndpoint end;

    @Override
    protected String getBlueprintDescriptor() {
        return "OSGI-INF/blueprint/camel.xml";
    }

    @Override
    protected String useOverridePropertiesWithConfigAdmin(Dictionary props) throws Exception {
        props.put("route.from", "direct:start");
        props.put("route.to", "mock:end");
        props.put("message.hello", "Hello from properties file");
        return "my-camel-route";
    }

    @Test
    public void testSimpleRouteTest() throws Exception {
        end.expectedMessageCount(1);

        template.send("direct:start", createExchangeWithBody("Hello from blueprint test"));

        end.assertIsSatisfied();

        Exchange result = end.getExchanges().get(0);

        assertThat(result.getIn().getBody(String.class), is("Hello from blueprint test"));
    }
}
