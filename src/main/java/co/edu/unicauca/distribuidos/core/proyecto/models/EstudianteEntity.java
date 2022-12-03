package co.edu.unicauca.distribuidos.core.proyecto.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
@Table(name = "Estudiante")
public class EstudianteEntity extends PersonaEntity{
    @Column(name="fechaIngreso", nullable = false)
    private Date fechaIngreso;

    @OneToOne(cascade = { CascadeType.ALL }, mappedBy = "objEstudiante")
	private DireccionEntity objDireccion; 

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "objEstudiante")
	private List<TelefonoEntity> telefonos;

    

    public EstudianteEntity()
    {
        super();
    }

    public EstudianteEntity(String  noIdentificacion, String tipoIdentificacion, String nombres, String apellidos, Date fechaIngreso)
    {
        super(noIdentificacion, tipoIdentificacion, nombres,  apellidos);
        this.fechaIngreso = fechaIngreso;
    }
}
