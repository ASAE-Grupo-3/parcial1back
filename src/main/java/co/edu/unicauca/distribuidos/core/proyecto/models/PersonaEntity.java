package co.edu.unicauca.distribuidos.core.proyecto.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import javax.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class PersonaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;
	
	@Column(name="noIdentificacion", nullable = false, length = 150, unique = true)
	private String noIdentificacion;
	
	@Column(name="tipoIdentificacion", nullable = false, length = 150)
	private String tipoIdentificacion;
	
	@Column(name="nombres", nullable = false, length = 150)
	private String nombres;
	
	@Column(name="apellidos", nullable = false, length = 150)
	private String apellidos;

	public PersonaEntity(String noIdentificacion, String tipoIdentificacion, String nombres, String apellidos) {
		super();
		this.noIdentificacion = noIdentificacion;
		this.tipoIdentificacion = tipoIdentificacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}
}
