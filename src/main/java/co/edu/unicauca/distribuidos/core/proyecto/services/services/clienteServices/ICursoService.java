package co.edu.unicauca.distribuidos.core.proyecto.services.services.clienteServices;

import java.util.List;
import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.EstudianteDTO;

public interface ICursoService {

	public List<EstudianteDTO> findAll();

	public EstudianteDTO findById(Integer id);

	public EstudianteDTO save(EstudianteDTO cliente);

	public EstudianteDTO update(Integer id, EstudianteDTO cliente);

	public boolean delete(Integer id);
}
