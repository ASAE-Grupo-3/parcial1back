package co.edu.unicauca.distribuidos.core.proyecto.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.distribuidos.core.proyecto.models.CursoEntity;

public interface CourseRepository extends CrudRepository<CursoEntity, Integer> {
    
}
