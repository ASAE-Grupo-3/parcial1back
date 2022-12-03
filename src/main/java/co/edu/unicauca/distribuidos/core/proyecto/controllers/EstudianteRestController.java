
package co.edu.unicauca.distribuidos.core.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.EstudianteDTO;
import co.edu.unicauca.distribuidos.core.proyecto.services.services.clienteServices.IEstudianteService;


@RestController
@RequestMapping("/api")
public class EstudianteRestController {

	@Autowired
	private IEstudianteService EstudianteService;

	@GetMapping("/estudiantes")
	public List<EstudianteDTO> index() {
		return EstudianteService.findAll();
	}

	@GetMapping("/estudiantes/{id}")
	public EstudianteDTO show(@PathVariable Integer id) {
		EstudianteDTO objEstudiante = null;
		objEstudiante = EstudianteService.findById(id);
		return objEstudiante;
	}

	@PostMapping("/estudiantes")
	public EstudianteDTO create(@RequestBody EstudianteDTO estudiante) {
		EstudianteDTO objEstudiante = null;
		objEstudiante = EstudianteService.save(estudiante);
		return objEstudiante;
	}

	@PutMapping("/estudiantes/{id}")
	public EstudianteDTO update(@RequestBody EstudianteDTO estudiante, @PathVariable Integer id) {
		EstudianteDTO objEstudiante = null;
		System.out.println("actualizando cliente");
		EstudianteDTO EstudianteActual = EstudianteService.findById(id);
		if (EstudianteActual != null) {
			objEstudiante = EstudianteService.update(id, estudiante);
		}
		return objEstudiante;
	}

	@DeleteMapping("/estudiantes/{id}")
	public Boolean delete(@PathVariable Integer id) {
		return this.EstudianteService.delete(id);

	}

}
