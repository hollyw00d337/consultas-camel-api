package com.proyecto.consultas.service;

import com.proyecto.consultas.model.Automovil;
import com.proyecto.consultas.repository.AutomovilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutomovilService {

    @Autowired
    private AutomovilRepository repository;

    // Método ÚNICO para que Camel no dude
    public List<Automovil> listarTodos() {
        return repository.findAll();
    }

    public Automovil guardar(Automovil auto) {
        return repository.save(auto);
    }

    public void borrar(Long id) {
        repository.deleteById(id);
    }
}
