package com.crudclinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crudclinica.dto.PacienteDTO;
import com.crudclinica.model.Paciente;
import com.crudclinica.service.PacienteService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    public PacienteService service;
    
    @GetMapping
    public List<PacienteDTO> getAll() {
        return service.getAll().stream()
                      .map(PacienteDTO::new)
                      .collect(Collectors.toList());
    }
    

    @GetMapping("/{id}")
    public Paciente getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public void addPaciente(@RequestBody Paciente paciente) {
        service.save(paciente);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Long id) {
        service.deletePaciente(id);
    }

    @PutMapping("/{id}")
    public void replace(@PathVariable Long id, @RequestBody PacienteDTO p) {
        service.updateById(id, p);
    }

}
