package com.crudclinica.dto;

import com.crudclinica.model.Paciente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PacienteDTO {

    private long id;
    private String nome;
    private long cpf;
    private Date dataNascimento;
    private String endereco;
    private long telefone;
    private String email;
    private String tipoSanguineo;
    private String convenio;
    private String nomeResponsavel;

    public PacienteDTO(Paciente p) {
        BeanUtils.copyProperties(p, this);
    }

}
