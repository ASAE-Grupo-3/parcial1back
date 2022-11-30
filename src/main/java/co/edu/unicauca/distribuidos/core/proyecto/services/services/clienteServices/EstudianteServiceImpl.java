
package co.edu.unicauca.distribuidos.core.proyecto.services.services.clienteServices;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.core.proyecto.models.EstudianteEntity;
import co.edu.unicauca.distribuidos.core.proyecto.models.DireccionEntity;
import co.edu.unicauca.distribuidos.core.proyecto.repositories.EstudianteRepository;
import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.EstudianteDTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private EstudianteRepository servicioAccesoBaseDatos;

	@Autowired
	@Qualifier("mapperEstudiante")
	private ModelMapper modelMapper;

	@Override
	@Transactional(readOnly = true)
	public List<EstudianteDTO> findAll() {
		Iterable<EstudianteEntity> estudiantesEntity = this.servicioAccesoBaseDatos.findAll();
		System.out.println("antes de la consulta"+ estudiantesEntity);	
		List<EstudianteDTO> estudiantesDTO = this.modelMapper.map(estudiantesEntity, new TypeToken<List<EstudianteDTO>>() {
		}.getType());
		return estudiantesDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public EstudianteDTO findById(Integer id) {
		Optional<EstudianteEntity> optional = this.servicioAccesoBaseDatos.findById(id);
		EstudianteEntity user = optional.get();
		System.out.println("antes de la consulta");
		EstudianteDTO EstudianteDTO = this.modelMapper.map(user, EstudianteDTO.class);
		return EstudianteDTO;
	}
	

	@Override
	@Transactional()
	public EstudianteDTO save(EstudianteDTO cliente) {

		EstudianteEntity EstudianteEntity = this.modelMapper.map(cliente, EstudianteEntity.class);
		EstudianteEntity.getObjDireccion().setObjEstudiante(EstudianteEntity);

		EstudianteEntity.getTelefonos().forEach(objTelefono -> objTelefono.setObjEstudiante(EstudianteEntity));

		EstudianteEntity objEstudianteEntity = this.servicioAccesoBaseDatos.save(EstudianteEntity);
		EstudianteDTO EstudianteDTO = this.modelMapper.map(objEstudianteEntity, EstudianteDTO.class);
		return EstudianteDTO;
	}

	@Override
	@Transactional(readOnly = false)
	public EstudianteDTO update(Integer id, EstudianteDTO objEstudianteConDatosNuevos) {
		Optional<EstudianteEntity> optional = this.servicioAccesoBaseDatos.findById(id);
		EstudianteDTO EstudianteDTOActualizado = null;
		EstudianteEntity objEstudianteAlmacenado = optional.get();

		if (objEstudianteAlmacenado != null) {

			objEstudianteAlmacenado.setIdPersona(objEstudianteConDatosNuevos.getIdPersona());
			objEstudianteAlmacenado.setNombres(objEstudianteConDatosNuevos.getNombres());
			objEstudianteAlmacenado.setApellidos(objEstudianteConDatosNuevos.getApellidos());
			objEstudianteAlmacenado.setTipoIdentificacion(objEstudianteConDatosNuevos.getTipoIdentificacion());
			objEstudianteAlmacenado.setNoIdentificacion(objEstudianteConDatosNuevos.getNoIdentificacion());
			objEstudianteAlmacenado.setFechaIngreso(objEstudianteConDatosNuevos.getFechaIngreso());
			DireccionEntity objDireccionAlmacenada = objEstudianteAlmacenado.getObjDireccion();
			objDireccionAlmacenada.setIdEstudiante(objEstudianteConDatosNuevos.getObjDireccion().getIdEstudiante());
			objDireccionAlmacenada.setTipoTelefono(objEstudianteConDatosNuevos.getObjDireccion().getTipoTelefono());
			objDireccionAlmacenada.setNumeroTelefono(objEstudianteConDatosNuevos.getObjDireccion().getNumeroTelefono());
			
			EstudianteEntity EstudianteEntityActualizado = this.servicioAccesoBaseDatos.save(objEstudianteAlmacenado);
			EstudianteDTOActualizado = this.modelMapper.map(EstudianteEntityActualizado, EstudianteDTO.class);
			 
		}
		return EstudianteDTOActualizado;
	}
	
	@Override
	@Transactional(readOnly = false)
	public boolean delete(Integer id) {
		boolean bandera = false;
		Optional<EstudianteEntity> optional = this.servicioAccesoBaseDatos.findById(id);
		EstudianteEntity user = optional.get();
		if (user != null) {
			this.servicioAccesoBaseDatos.delete(user);
			bandera = true;
		}

		return bandera;
	}

}
