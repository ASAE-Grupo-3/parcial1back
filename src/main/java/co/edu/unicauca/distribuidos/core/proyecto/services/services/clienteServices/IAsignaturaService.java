package co.edu.unicauca.distribuidos.core.proyecto.services.services.clienteServices;

import java.util.List;

import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.AsignaturaDTO;

public interface IAsignaturaService {

    public List<AsignaturaDTO> findAll();

	public AsignaturaDTO findById(Integer id);

	public AsignaturaDTO save(AsignaturaDTO cliente);

	public AsignaturaDTO update(Integer id, AsignaturaDTO cliente);

	public boolean delete(Integer id);
}
