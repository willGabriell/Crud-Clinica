package com.crudclinica.service;

import com.crudclinica.dto.PacienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crudclinica.model.Paciente;
import com.crudclinica.repository.PacienteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    public PacienteRepository repository;

    public List<Paciente> getAll() {
        return repository.findAll();
    } 

    public Paciente getById(Long id) {
        Optional<Paciente> optionalPaciente = repository.findById(id);
        Paciente paciente = optionalPaciente.orElseThrow();
        return paciente;
    }

    public void save(Paciente paciente) {
        if(paciente != null){
            repository.save(paciente);
        } else {
            throw new IllegalArgumentException("Paciente não pode ser nulo");
        }
    }

    public void deletePaciente(Long id) {
        Paciente pacienteToDelete = getById(id);
        repository.delete(pacienteToDelete);
    }

    public Paciente updateById(Long id, PacienteDTO pacienteDTO) {
        Paciente paciente = getById(id);

        paciente.setNome(pacienteDTO.getNome());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setDataNascimento(pacienteDTO.getDataNascimento());
        paciente.setEndereco(pacienteDTO.getEndereco());
        paciente.setTelefone(pacienteDTO.getTelefone());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setTipoSanguineo(pacienteDTO.getTipoSanguineo());
        paciente.setConvenio(pacienteDTO.getConvenio());
        paciente.setNomeResponsavel(pacienteDTO.getNomeResponsavel());

        return repository.save(paciente);

    }

}
