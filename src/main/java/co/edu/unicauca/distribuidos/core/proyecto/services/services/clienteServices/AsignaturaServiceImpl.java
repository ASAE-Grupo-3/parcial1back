package co.edu.unicauca.distribuidos.core.proyecto.services.services.clienteServices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.distribuidos.core.proyecto.models.AsignaturaEntity;
import co.edu.unicauca.distribuidos.core.proyecto.repositories.AsignaturaRepository;
import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.AsignaturaDTO;

public class AsignaturaServiceImpl implements IAsignaturaService{

    private AsignaturaRepository servicioAccesoBaseDatos;

    @Autowired
    @Qualifier("mapperAsignatura")
    ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<AsignaturaDTO> findAll() {
        Iterable<AsignaturaEntity> asignaturasEntity = this.servicioAccesoBaseDatos.findAll();
		System.out.println("antes de la consulta"+ asignaturasEntity);	
		List<AsignaturaDTO> asignaturaDTO = this.modelMapper.map(asignaturasEntity, new TypeToken<List<AsignaturaDTO>>() {
		}.getType());
		return asignaturaDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public AsignaturaDTO findById(Integer id) {
        Optional<AsignaturaEntity> optional = this.servicioAccesoBaseDatos.findById(id);
		AsignaturaEntity user = optional.get();
		System.out.println("antes de la consulta");
		AsignaturaDTO asignaturaDTO = this.modelMapper.map(user, AsignaturaDTO.class);
		return asignaturaDTO;
    }

    @Override
    public AsignaturaDTO save(AsignaturaDTO cliente) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AsignaturaDTO update(Integer id, AsignaturaDTO cliente) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
