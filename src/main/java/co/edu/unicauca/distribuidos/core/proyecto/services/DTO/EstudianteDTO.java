package co.edu.unicauca.distribuidos.core.proyecto.services.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class EstudianteDTO extends PersonaDTO{
    private Date fechaIngreso;
    
	private DireccionDTO objDireccion;
    
	private List<TelefonoDTO> telefonos = new ArrayList<>();

    public EstudianteDTO()
    {
        super();
    }

    public EstudianteDTO(String  noIdentificacion, String tipoIdentificacion, String nombres, String apellidos, Date fechaIngreso)
    {
        super(noIdentificacion, tipoIdentificacion, nombres,  apellidos);
        this.fechaIngreso = fechaIngreso;
    }
}
