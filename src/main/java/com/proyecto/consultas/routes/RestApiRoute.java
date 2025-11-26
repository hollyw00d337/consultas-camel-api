package com.proyecto.consultas.routes;

import com.proyecto.consultas.model.Consulta;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestApiRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        // Configuración general de REST
        restConfiguration()
            .component("servlet")
            .bindingMode(RestBindingMode.json);

        // Definición de las rutas (Endpoints)
        rest("/consultas")

            // POST: Crear consulta
            .post()
                .type(Consulta.class)
                .to("bean:consultaRepository?method=save")

            // GET: Listar todas
            .get()
                .to("bean:consultaRepository?method=findAll")

            // DELETE: Borrar por ID
            .delete("/{id}")
                .to("bean:consultaRepository?method=deleteById(${header.id})");
    }
}
