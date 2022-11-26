package co.edu.unicauca.distribuidos.core.proyecto.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class EstudianteEntity extends PersonaEntity{
    private Date fechaIngreso;

    @OneToOne(optional = false, cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "objEstudiante")
	private DireccionEntity objDireccion;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "objEstudiante")
	private List<TelefonoEntity> telefonos;

    public EstudianteEntity()
    {
        super();
    }

    public EstudianteEntity(int idPersona, String  noIdentificacion, String tipoIdentificacion, String nombres, String apellidos, Date fechaIngreso)
    {
        super(idPersona, noIdentificacion, tipoIdentificacion, nombres,  apellidos);
        this.fechaIngreso = fechaIngreso;
    }
}
