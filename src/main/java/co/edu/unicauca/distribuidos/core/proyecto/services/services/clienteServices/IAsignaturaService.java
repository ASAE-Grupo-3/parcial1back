package co.edu.unicauca.distribuidos.core.proyecto.services.services.clienteServices;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.AsignaturaDTO;


public interface IAsignaturaService {

    public List<AsignaturaDTO> findAll();

	public AsignaturaDTO findById(Integer id);

	public AsignaturaDTO save(AsignaturaDTO asignaturaDTO);

	public AsignaturaDTO update(Integer id, AsignaturaDTO asignaturaDTO);

	public boolean delete(Integer id);
}
