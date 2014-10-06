package camel.simple;

import org.apache.camel.builder.RouteBuilder;

public class SecondRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {

        from("direct:catre_ruta_2")
                .routeId("a doua ruta")
                .log(" ${file:size}")
                .to("file://target/output");

    }
}
