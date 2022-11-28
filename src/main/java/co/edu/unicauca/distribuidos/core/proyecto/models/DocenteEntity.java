package co.edu.unicauca.distribuidos.core.proyecto.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
@Table(name = "Docente")
public class DocenteEntity extends PersonaEntity {
	
    @Column(name="universidad", nullable = false, length = 150)
    private String universidad;
    
    @Column(name="tipoDocente", nullable = false, length = 150)
    private String tipoDocente;
    
    @Column(name="salario", nullable = false, length = 150)
    private Float salario;

    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="Docente_Asignatura", joinColumns = @JoinColumn(name="idPersona"), inverseJoinColumns = @JoinColumn(name="idAsignatura"))
	private List<AsignaturaEntity> Asignaturas = new ArrayList<>();
    
    public DocenteEntity()
    {
        super();
    }

    public DocenteEntity(String  noIdentificacion, String tipoIdentificacion, String nombres, String apellidos, String universidad, String tipoDocente, Float salario)
    {
        super(noIdentificacion, tipoIdentificacion, nombres,  apellidos);
        this.universidad = universidad;
        this.tipoDocente = tipoDocente;
        this.salario = salario;
    }
}
