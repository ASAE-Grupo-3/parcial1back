package co.edu.unicauca.distribuidos.core.proyecto.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name ="Cursos")
public class CursoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -409626244432219617L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCurso;
	
    @Column(name="nombre", nullable = false, length = 150)
    private String nombre;
    
    @Column(name="periodo", nullable = false, length = 150)
    private String periodo;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="idAsignatura", nullable=false)
    private AsignaturaEntity objAsignatura;

}
