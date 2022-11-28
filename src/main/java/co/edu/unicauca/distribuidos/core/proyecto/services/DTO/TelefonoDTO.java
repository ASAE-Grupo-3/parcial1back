package co.edu.unicauca.distribuidos.core.proyecto.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelefonoDTO {

    private Integer idTelefono;
    private String tipo;
    private String numero;
	private EstudianteDTO objEstudiante;
}
