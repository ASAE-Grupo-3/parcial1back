package co.edu.unicauca.distribuidos.core.proyecto.services.services.clienteServices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.distribuidos.core.proyecto.models.AsignaturaEntity;
import co.edu.unicauca.distribuidos.core.proyecto.repositories.AsignaturaRepository;
import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.AsignaturaDTO;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService{

    @Autowired
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
    @Transactional
    public AsignaturaDTO save(AsignaturaDTO asignaturaDTO) {
        AsignaturaDTO objasignaturaDTO = null;
        if(asignaturaDTO.getCursos().size() > 0 && asignaturaDTO.getDocentes().size() >= 2){
            AsignaturaEntity asignaturaEntity = this.modelMapper.map(asignaturaDTO, AsignaturaEntity.class);
            asignaturaEntity.getDocentes().forEach(objDocente -> objDocente.addAsignatura(asignaturaEntity));
            asignaturaEntity.getCursos().forEach(objCurso -> objCurso.setObjAsignatura(asignaturaEntity));

            AsignaturaEntity objAsignaturaEntity = servicioAccesoBaseDatos.save(asignaturaEntity);
            objasignaturaDTO = this.modelMapper.map(objAsignaturaEntity, AsignaturaDTO.class);
        }
        return objasignaturaDTO;
    }

    @Override
    public AsignaturaDTO update(Integer id, AsignaturaDTO asignaturaDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
