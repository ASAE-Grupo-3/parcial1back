package co.edu.unicauca.distribuidos.core.proyecto.models;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class DocenteEntity extends PersonaEntity{
    private String universidad;
    private String tipoDocente;
    private Float salario;

    public DocenteEntity()
    {
        super();
    }

    public DocenteEntity(int idPersona, String  noIdentificacion, String tipoIdentificacion, String nombres, String apellidos, String universidad, String tipoDocente, Float salario)
    {
        super(idPersona, noIdentificacion, tipoIdentificacion, nombres,  apellidos);
        this.universidad = universidad;
        this.tipoDocente = tipoDocente;
        this.salario = salario;
    }
}
