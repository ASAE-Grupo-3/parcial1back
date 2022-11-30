package co.edu.unicauca.distribuidos.core.proyecto.services.services.clienteServices;

import java.util.List;
import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.DocenteDTO;

public interface IDocenteService {

	public List<DocenteDTO> findAll();

	public DocenteDTO findById(Integer id);

	public DocenteDTO save(DocenteDTO cliente);

	public DocenteDTO update(Integer id, DocenteDTO cliente);

	public boolean delete(Integer id);
}
