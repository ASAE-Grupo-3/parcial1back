
package co.edu.unicauca.distribuidos.core.proyecto.services.services.clienteServices;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.core.proyecto.models.DocenteEntity;
import co.edu.unicauca.distribuidos.core.proyecto.models.DireccionEntity;
import co.edu.unicauca.distribuidos.core.proyecto.repositories.DocenteRepository;
import co.edu.unicauca.distribuidos.core.proyecto.repositories.EstudianteRepository;
import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.DocenteDTO;

@Service
public class DocenteServiceImpl implements IDocenteService {

	@Autowired
	private DocenteRepository servicioAccesoBaseDatos;

	@Autowired
	@Qualifier("mapperDocente")
	private ModelMapper modelMapper;

	@Override
	@Transactional(readOnly = true)
	public List<DocenteDTO> findAll() {
		Iterable<DocenteEntity> docentesEntity = this.servicioAccesoBaseDatos.findAll();
		System.out.println("antes de la consulta"+ docentesEntity);	
		List<DocenteDTO> docentesDTO = this.modelMapper.map(docentesEntity, new TypeToken<List<DocenteDTO>>() {
		}.getType());
		return docentesDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public DocenteDTO findById(Integer id) {
		Optional<DocenteEntity> optional = this.servicioAccesoBaseDatos.findById(id);
		DocenteEntity user = optional.get();
		System.out.println("antes de la consulta");
		DocenteDTO DocenteDTO = this.modelMapper.map(user, DocenteDTO.class);
		return DocenteDTO;
	}
	

	@Override
	@Transactional()
	public DocenteDTO save(DocenteDTO cliente) {

		DocenteEntity docenteEntity = this.modelMapper.map(cliente, DocenteEntity.class);

		DocenteEntity objDocenteEntity = this.servicioAccesoBaseDatos.save(docenteEntity);
		DocenteDTO DocenteDTO = this.modelMapper.map(objDocenteEntity, DocenteDTO.class);
		return DocenteDTO;
	}

	@Override
	@Transactional(readOnly = false)
	public DocenteDTO update(Integer id, DocenteDTO objEstudianteConDatosNuevos) {
		Optional<DocenteEntity> optional = this.servicioAccesoBaseDatos.findById(id);
		DocenteDTO docenteDTOActualizado = null;
		DocenteEntity objEstudianteAlmacenado = optional.get();

		/*
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
			
			DocenteEntity DocenteEntityActualizado = this.servicioAccesoBaseDatos.save(objEstudianteAlmacenado);
			docenteDTOActualizado = this.modelMapper.map(DocenteEntityActualizado, DocenteDTO.class);
			 
		}
		*/
		return docenteDTOActualizado;
	}
	
	/*
	 * Eliminar estudiante por su id.
	 */
	@Override
	@Transactional(readOnly = false)
	public boolean delete(Integer id) {
		boolean bandera = false;
		Optional<DocenteEntity> optional = this.servicioAccesoBaseDatos.findById(id);
		DocenteEntity user = optional.get();
		if (user != null) {
			this.servicioAccesoBaseDatos.delete(user);
			bandera = true;
		}

		return bandera;
	}

}
