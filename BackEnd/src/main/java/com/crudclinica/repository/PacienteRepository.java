package com.crudclinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crudclinica.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
