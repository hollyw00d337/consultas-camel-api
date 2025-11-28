package com.proyecto.consultas.routes;

import com.proyecto.consultas.model.Automovil;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;
import org.springframework.http.MediaType;

@Component
public class RestApiRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
            .component("servlet")
            .bindingMode(RestBindingMode.json);

        rest("/autos")
            .consumes(MediaType.APPLICATION_JSON_VALUE)
            .produces(MediaType.APPLICATION_JSON_VALUE)

            // GET: Llama a 'automovilService'
            .get()
                .to("bean:automovilService?method=listarTodos")

            // POST: Llama a 'automovilService'
            .post().type(Automovil.class)
                .to("bean:automovilService?method=guardar")

            // DELETE: Llama a 'automovilService'
            .delete("/{id}")
                .to("bean:automovilService?method=borrar(${header.id})");
    }
}
