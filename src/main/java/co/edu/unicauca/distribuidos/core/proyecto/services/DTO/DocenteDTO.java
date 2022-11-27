package co.edu.unicauca.distribuidos.core.proyecto.services.DTO;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class DocenteDTO extends PersonaDTO{

    private String universidad;
    private String tipoDocente;
    private Float salario;
	private List<AsignaturaDTO> Asignaturas;
    
    public DocenteDTO()
    {
        super();
    }

    public DocenteDTO(int idPersona, String  noIdentificacion, String tipoIdentificacion, String nombres, String apellidos, String universidad, String tipoDocente, Float salario)
    {
        super(idPersona, noIdentificacion, tipoIdentificacion, nombres,  apellidos);
        this.universidad = universidad;
        this.tipoDocente = tipoDocente;
        this.salario = salario;
    }
}
