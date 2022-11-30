package co.edu.unicauca.distribuidos.core.proyecto.services.DTO;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6905440751853724966L;
	private Integer idCurso;
    private String nombre;
    private String periodo;
    private AsignaturaDTO objAsignatura;

}
