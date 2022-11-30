package co.edu.unicauca.distribuidos.core.proyecto.services.mapper.estudianteMappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.distribuidos.core.proyecto.models.AsignaturaEntity;
import co.edu.unicauca.distribuidos.core.proyecto.models.EstudianteEntity;
import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.AsignaturaDTO;
import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.EstudianteDTO;

@Configuration
public class Mapper {
    @Bean(name = "mapperEstudiante")
    public ModelMapper modelMapperStudent() {
        ModelMapper objMapper = new ModelMapper();
        //TypeMap<EstudianteEntity, EstudianteDTO> mapa = objMapper.emptyTypeMap(EstudianteEntity.class, EstudianteDTO.class);
        //mapa.addMappings(n -> n.skip(EstudianteDTO::setObjDireccion)).implicitMappings();
        //mapa.addMappings(m -> m.skip(EstudianteDTO::setTelefonos)).implicitMappings();
        return objMapper;
    }

    @Bean(name = "mapperAsignatura")
    public ModelMapper modelMapperAsignatura() {
        ModelMapper objMapper = new ModelMapper();
        TypeMap<AsignaturaEntity, AsignaturaDTO> mapa = objMapper.emptyTypeMap(AsignaturaEntity.class, AsignaturaDTO.class);
        mapa.addMappings(n -> n.skip(AsignaturaDTO::setCursos)).implicitMappings();
        return objMapper;
    }
}
