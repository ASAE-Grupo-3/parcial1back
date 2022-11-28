package co.edu.unicauca.distribuidos.core.proyecto.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Asignaturas")
public class AsignaturaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAsignatura;
	@Column(name = "nombre", nullable = false, length = 150)
	private String nombre;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Docente_Asignatura", joinColumns = @JoinColumn(name = "idAsignatura"), inverseJoinColumns = @JoinColumn(name = "idPersona"))
	private List<DocenteEntity> docentes  = new ArrayList<>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "objAsignatura")
	private List<CursoEntity> Cursos  = new ArrayList<>();

}