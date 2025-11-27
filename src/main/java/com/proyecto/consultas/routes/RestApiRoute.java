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

        // Configuración global
        restConfiguration()
            .component("servlet")
            .bindingMode(RestBindingMode.json);

        // Definición de las Rutas
        rest("/autos")
            .consumes(MediaType.APPLICATION_JSON_VALUE)
            .produces(MediaType.APPLICATION_JSON_VALUE)

            // GET: Ver todos
            // Usamos "bean:" seguido del nombre de la variable del repositorio (camelCase)
            .get()
                .to("bean:automovilRepository?method=findAll")

            // POST: Guardar
            .post().type(Automovil.class)
                .to("bean:automovilRepository?method=save")

            // DELETE: Borrar por ID
            .delete("/{id}")
                .to("bean:automovilRepository?method=deleteById(${header.id})");
    }
}
