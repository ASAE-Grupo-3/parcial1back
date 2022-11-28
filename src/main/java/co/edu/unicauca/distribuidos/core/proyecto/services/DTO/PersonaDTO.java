package co.edu.unicauca.distribuidos.core.proyecto.services.DTO;


import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class PersonaDTO {

	private Integer idPersona;
	private String noIdentificacion;
	private String tipoIdentificacion;
	private String nombres;
	private String apellidos;
	
	public PersonaDTO(String noIdentificacion, String tipoIdentificacion, String nombres, String apellidos) {
		super();
		this.noIdentificacion = noIdentificacion;
		this.tipoIdentificacion = tipoIdentificacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}
	
}
