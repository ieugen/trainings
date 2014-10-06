package camel.simple.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileNamePrependerProcessor implements Processor {



    @Override
    public void process(Exchange exchange) throws Exception {
        String file = exchange.getIn().getHeader(Exchange.FILE_NAME,String.class);
        exchange.getIn().setHeader(Exchange.FILE_NAME, "PRE_FIX_"+file);
        exchange.getIn().getBody(String.class);

    }

}
