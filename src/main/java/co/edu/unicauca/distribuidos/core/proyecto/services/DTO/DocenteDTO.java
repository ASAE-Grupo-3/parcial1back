package co.edu.unicauca.distribuidos.core.proyecto.services.DTO;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DocenteDTO extends PersonaDTO{

    private String universidad;
    private String tipoDocente;
    private Float salario;
    @JsonIgnore
	private List<AsignaturaDTO> Asignaturas = new ArrayList<>();
    
    public DocenteDTO()
    {
        super();
    }

    public DocenteDTO(String  noIdentificacion, String tipoIdentificacion, String nombres, String apellidos, String universidad, String tipoDocente, Float salario)
    {
        super(noIdentificacion, tipoIdentificacion, nombres,  apellidos);
        this.universidad = universidad;
        this.tipoDocente = tipoDocente;
        this.salario = salario;
    }
}
