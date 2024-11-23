package com.crudclinica.model;

import java.util.Date;

import com.crudclinica.dto.PacienteDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private long cpf;
    private Date dataNascimento;
    private String endereco;
    private long telefone;
    private String email;
    private String tipoSanguineo;
    private String convenio;
    private String nomeResponsavel;

    public Paciente(PacienteDTO p) {
        BeanUtils.copyProperties(p, this);
    }

}
