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

import co.edu.unicauca.distribuidos.core.proyecto.models.AsignaturaEntity;
import co.edu.unicauca.distribuidos.core.proyecto.models.CursoEntity;
import co.edu.unicauca.distribuidos.core.proyecto.repositories.AsignaturaRepository;
import co.edu.unicauca.distribuidos.core.proyecto.repositories.CursoRepository;
import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.AsignaturaDTO;
import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.CursoDTO;
@Service
public class CursoServiceImpl implements ICursoService {

    @Autowired
	private CursoRepository servicioAccesoBaseDatos;
    
    @Autowired
    private AsignaturaRepository servicioAsignatura;

    @Autowired
	@Qualifier("mapperCurso")
	private ModelMapper modelMapper;

	@Override
	@Transactional(readOnly = true)
	public List<CursoDTO> findAll() {
		Iterable<CursoEntity> cursosEntity = this.servicioAccesoBaseDatos.findAll();
		System.out.println("antes de la consulta"+ cursosEntity);	
		List<CursoDTO> cursosDTO = this.modelMapper.map(cursosEntity, new TypeToken<List<CursoDTO>>() {}.getType());
		cursosDTO.forEach(t->t.getObjAsignatura().setDocentes(new ArrayList<>()));
		return cursosDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public CursoDTO findById(Integer id) {
		CursoDTO cursoDTO = null;
		Optional<CursoEntity> optional = this.servicioAccesoBaseDatos.findById(id);
		if (optional.isPresent()) {
			CursoEntity curso = optional.get();
			System.out.println("antes de la consulta");
			cursoDTO = this.modelMapper.map(curso, CursoDTO.class);
			cursoDTO.getObjAsignatura().setDocentes(new ArrayList<>());
		}
		
		return cursoDTO;
	}
	

	@Override
	@Transactional()
	public CursoDTO save(CursoDTO cursoDTO) {
		
		AsignaturaEntity asignatura = this.servicioAsignatura.findById(cursoDTO.getObjAsignatura().getIdAsignatura()).orElse(null);
		CursoDTO cursoRespuesta = null;
		if (cursoDTO.getObjAsignatura()!=null && asignatura!=null) {
			
			CursoEntity cursoEntity = this.modelMapper.map(cursoDTO, CursoEntity.class);
			cursoEntity.setObjAsignatura(asignatura);
			if(cursoEntity.getObjAsignatura().getCursos()!=null)
				cursoEntity.getObjAsignatura().getCursos().add(cursoEntity);
			
			CursoEntity objCursoEntity = this.servicioAccesoBaseDatos.save(cursoEntity);
			cursoRespuesta = this.modelMapper.map(objCursoEntity, CursoDTO.class);
			cursoRespuesta.getObjAsignatura().setDocentes(new ArrayList<>());
		}
		
		return cursoRespuesta;
	}

	@Override
	@Transactional(readOnly = false)
	public CursoDTO update(Integer id, CursoDTO objcursoConDatosNuevos) {
        return null;
	}
	
	@Override
	@Transactional(readOnly = false)
	public boolean delete(Integer id) {
		
		boolean estado = false;
		if(this.servicioAccesoBaseDatos.existsById(id)) {
			this.servicioAccesoBaseDatos.deleteById(id);
			estado = !this.servicioAccesoBaseDatos.existsById(id);
		}
		return estado;
	}
}
