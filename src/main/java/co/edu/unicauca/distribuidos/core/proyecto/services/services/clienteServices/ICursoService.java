package co.edu.unicauca.distribuidos.core.proyecto.services.services.clienteServices;

import java.util.List;

import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.CursoDTO;

public interface ICursoService {

    public List<CursoDTO> findAll();

	public CursoDTO findById(Integer id);

	public CursoDTO save(CursoDTO curso);

	public CursoDTO update(Integer id, CursoDTO curso);

	public boolean delete(Integer id);
    
}
