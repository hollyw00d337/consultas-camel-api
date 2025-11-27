package com.proyecto.consultas.routes;

import com.proyecto.consultas.model.Consulta;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestApiRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
        restConfiguration()
            .component("servlet")
            .bindingMode(RestBindingMode.json);

        // Ruta relativa (se sumará al /api del properties)
        rest("/consultas")
            .consumes("application/json")
            .produces("application/json")
            
            .post()
                .type(Consulta.class)
                .to("bean:consultaRepository?method=save")
            
            .get()
                .to("bean:consultaRepository?method=findAll")
            
            .delete("/{id}")
                .to("bean:consultaRepository?method=deleteById(${header.id})");
    }
}
