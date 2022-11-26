package co.edu.unicauca.distribuidos.core.proyecto.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "Telefono")
public class TelefonoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTelefono;
    private String tipo;
    private String numero;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "idPersona", nullable = false)
	private EstudianteEntity objEstudiante;
}
