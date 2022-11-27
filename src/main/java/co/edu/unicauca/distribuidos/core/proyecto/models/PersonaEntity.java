package co.edu.unicauca.distribuidos.core.proyecto.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class PersonaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;
	
	@Column(name="noIdentificacion", nullable = false, length = 150)
	private String noIdentificacion;
	@Column(name="tipoIdentificacion", nullable = false, length = 150)
	private String tipoIdentificacion;
	@Column(name="nombres", nullable = false, length = 150)
	private String nombres;
	@Column(name="apellidos", nullable = false, length = 150)
	private String apellidos;
}
