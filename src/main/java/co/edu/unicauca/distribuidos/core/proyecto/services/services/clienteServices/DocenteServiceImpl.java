
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
import co.edu.unicauca.distribuidos.core.proyecto.repositories.DocenteRepository;
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
		DocenteEntity docente = optional.get();
		System.out.println("antes de la consulta");
		DocenteDTO DocenteDTO = this.modelMapper.map(docente, DocenteDTO.class);
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
	@Transactional()
	public DocenteDTO update(Integer id, DocenteDTO objDocenteConDatosNuevos) {
		Optional<DocenteEntity> optional = this.servicioAccesoBaseDatos.findById(id);
		DocenteDTO docenteDTOActualizado = null;
		DocenteEntity objDocenteAlmacenado = optional.get();

		
		if (objDocenteAlmacenado != null) {

			objDocenteAlmacenado.setIdPersona(objDocenteConDatosNuevos.getIdPersona());
			objDocenteAlmacenado.setNombres(objDocenteConDatosNuevos.getNombres());
			objDocenteAlmacenado.setApellidos(objDocenteConDatosNuevos.getApellidos());
			objDocenteAlmacenado.setTipoIdentificacion(objDocenteConDatosNuevos.getTipoIdentificacion());
			objDocenteAlmacenado.setNoIdentificacion(objDocenteConDatosNuevos.getNoIdentificacion());
			
			objDocenteAlmacenado.setUniversidad(objDocenteConDatosNuevos.getUniversidad());
			objDocenteAlmacenado.setTipoDocente(objDocenteConDatosNuevos.getTipoDocente());
			objDocenteAlmacenado.setSalario(objDocenteConDatosNuevos.getSalario());
			
			DocenteEntity DocenteEntityActualizado = this.servicioAccesoBaseDatos.save(objDocenteAlmacenado);
			docenteDTOActualizado = this.modelMapper.map(DocenteEntityActualizado, DocenteDTO.class);
			 
		}
		
		return docenteDTOActualizado;
	}
	
	@Override
	@Transactional()
	public boolean delete(Integer id) {
		boolean bandera = false;
		//DocenteEntity optional = this.servicioAccesoBaseDatos.findById(id).orElse(null);
		if (this.servicioAccesoBaseDatos.existsById(id)) {
			this.servicioAccesoBaseDatos.deleteById(id);
			
			bandera = true;
		}
		return bandera;
	}

}
