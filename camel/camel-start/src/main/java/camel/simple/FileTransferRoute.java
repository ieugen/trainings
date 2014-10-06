package camel.simple;

import camel.simple.processors.FileNamePrependerProcessor;
import org.apache.camel.builder.RouteBuilder;

public class FileTransferRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("file://target/input")
                .routeId("FileTransfer Route")
                .transacted()
                .log("Processing file ${file:name}")
                .process(new FileNamePrependerProcessor())
                .process(new FileNamePrependerProcessor())
                .to("direct:catre_ruta_2");

        from("timer://my-timer?period=10s")
                .routeId("timer route")
                .log("Mesaj de la timer")
                .setBody(constant("cev text"))
                .to("direct:catre_ruta_2");
    }
}
