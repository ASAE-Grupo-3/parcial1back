
package co.edu.unicauca.distribuidos.core.proyecto.services.services.clienteServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.core.proyecto.models.EstudianteEntity;
import co.edu.unicauca.distribuidos.core.proyecto.models.DireccionEntity;
import co.edu.unicauca.distribuidos.core.proyecto.repositories.EstudianteRepository;
import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.EstudianteDTO;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private EstudianteRepository servicioAccesoBaseDatos;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional(readOnly = true)
	public List<EstudianteDTO> findAll() {
		Iterable<EstudianteEntity> estudiantesEntity = this.servicioAccesoBaseDatos.findAll();
		System.out.println("antes de la consulta");
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
		//EstudianteEntity.getSolicitudes().forEach(objSolicitud -> objSolicitud.setObjUsuario(EstudianteEntity));

		EstudianteEntity objEstudianteEntity = this.servicioAccesoBaseDatos.save(EstudianteEntity);
		EstudianteDTO EstudianteDTO = this.modelMapper.map(objEstudianteEntity, EstudianteDTO.class);
		return EstudianteDTO;
	}

	@Override
	@Transactional(readOnly = false)
	public EstudianteDTO update(Integer id, EstudianteDTO objClienteConDatosNuevos) {
		Optional<EstudianteEntity> optional = this.servicioAccesoBaseDatos.findById(id);
		EstudianteDTO EstudianteDTOActualizado = null;
		EstudianteEntity objClienteAlmacenado = optional.get();

		if (objClienteAlmacenado != null) {

			/*
			objClienteAlmacenado.setId(objClienteConDatosNuevos.getId());
			objClienteAlmacenado.setNombre(objClienteConDatosNuevos.getNombre());
			objClienteAlmacenado.setApellido(objClienteConDatosNuevos.getApellido());
			objClienteAlmacenado.setEmail(objClienteConDatosNuevos.getEmail());
			DireccionEntity objDireccionAlmacenada = objClienteAlmacenado.getObjDireccion();
			objDireccionAlmacenada.setIdUsuario(objClienteConDatosNuevos.getObjDireccion().getId());
			objDireccionAlmacenada.setCiudad(objClienteConDatosNuevos.getObjDireccion().getCiudad());
			objDireccionAlmacenada.setCalle(objClienteConDatosNuevos.getObjDireccion().getCalle());
			objDireccionAlmacenada.setPais(objClienteConDatosNuevos.getObjDireccion().getPais());
			EstudianteEntity EstudianteEntityActualizado = this.servicioAccesoBaseDatos.save(objClienteAlmacenado);
			EstudianteDTOActualizado = this.modelMapper.map(EstudianteEntityActualizado, EstudianteDTO.class);
			 */
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
