package co.edu.unicauca.distribuidos.core.proyecto.services.services.clienteServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.core.proyecto.models.CursoEntity;
import co.edu.unicauca.distribuidos.core.proyecto.repositories.CursoRepository;
import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.CursoDTO;
@Service
public class CursoServiceImpl implements ICursoService {

    @Autowired
	private CursoRepository servicioAccesoBaseDatos;

    @Autowired
	@Qualifier("mapperCurso")
	private ModelMapper modelMapper;

	@Override
	@Transactional(readOnly = true)
	public List<CursoDTO> findAll() {
		Iterable<CursoEntity> cursosEntity = this.servicioAccesoBaseDatos.findAll();
		System.out.println("antes de la consulta"+ cursosEntity);	
		List<CursoDTO> cursosDTO = this.modelMapper.map(cursosEntity, new TypeToken<List<CursoDTO>>() {}.getType());
		return cursosDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public CursoDTO findById(Integer id) {
		Optional<CursoEntity> optional = this.servicioAccesoBaseDatos.findById(id);
		CursoEntity curso = optional.get();
		System.out.println("antes de la consulta");
		CursoDTO CursoDTO = this.modelMapper.map(curso, CursoDTO.class);
		return CursoDTO;
	}
	

	@Override
	@Transactional()
	public CursoDTO save(CursoDTO curso) {

		CursoEntity CursoEntity = this.modelMapper.map(curso, CursoEntity.class);
        List<CursoEntity> cursoList = new ArrayList<>();
        cursoList.add(CursoEntity);
		CursoEntity.getObjAsignatura().setCursos(cursoList);

		CursoEntity objCursoEntity = this.servicioAccesoBaseDatos.save(CursoEntity);
		CursoDTO CursoDTO = this.modelMapper.map(objCursoEntity, CursoDTO.class);
		return CursoDTO;
	}

	@Override
	@Transactional(readOnly = false)
	public CursoDTO update(Integer id, CursoDTO objcursoConDatosNuevos) {
		// TODO Auto-generated method stub
        return null;
	}
	
	@Override
	@Transactional(readOnly = false)
	public boolean delete(Integer id) {
		boolean bandera = false;
		Optional<CursoEntity> optional = this.servicioAccesoBaseDatos.findById(id);
		CursoEntity user = optional.get();
		if (user != null) {
			this.servicioAccesoBaseDatos.delete(user);
			bandera = true;
		}

		return bandera;
	}
}
