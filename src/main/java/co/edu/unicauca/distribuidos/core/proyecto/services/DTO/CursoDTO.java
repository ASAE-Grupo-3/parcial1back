package co.edu.unicauca.distribuidos.core.proyecto.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {

	private Integer idCurso;
    private String nombre;
    private String periodo;
    private AsignaturaDTO objAsignatura;

}
