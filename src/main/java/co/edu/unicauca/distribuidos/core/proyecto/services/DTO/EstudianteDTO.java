package co.edu.unicauca.distribuidos.core.proyecto.services.DTO;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class EstudianteDTO extends PersonaDTO{
    private Date fechaIngreso;

	private DireccionDTO objDireccion;

	private List<TelefonoDTO> telefonos;

    public EstudianteDTO()
    {
        super();
    }

    public EstudianteDTO(int idPersona, String  noIdentificacion, String tipoIdentificacion, String nombres, String apellidos, Date fechaIngreso)
    {
        super(idPersona, noIdentificacion, tipoIdentificacion, nombres,  apellidos);
        this.fechaIngreso = fechaIngreso;
    }
}
