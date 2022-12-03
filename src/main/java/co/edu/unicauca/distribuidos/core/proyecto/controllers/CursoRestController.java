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

import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.CursoDTO;
import co.edu.unicauca.distribuidos.core.proyecto.services.services.clienteServices.ICursoService;

@RestController
@RequestMapping("/api")
public class CursoRestController {

    @Autowired
	private ICursoService CursoService;

	@GetMapping("/cursos")
	public List<CursoDTO> index() {
		return CursoService.findAll();
	}

	@GetMapping("/cursos/{id}")
	public CursoDTO show(@PathVariable Integer id) {
		CursoDTO objCurso = null;
		objCurso = CursoService.findById(id);
		return objCurso;
	}

	@PostMapping("/cursos")
	public CursoDTO create(@RequestBody CursoDTO curso) {
		CursoDTO objCurso = null;
		objCurso = CursoService.save(curso);
		return objCurso;
	}

	@PutMapping("/cursos/{id}")
	public CursoDTO update(@RequestBody CursoDTO curso, @PathVariable Integer id) {
		CursoDTO objCurso = null;
		System.out.println("actualizando cliente");
		CursoDTO CursoActual = CursoService.findById(id);
		if (CursoActual != null) {
			objCurso = CursoService.update(id, curso);
		}
		return objCurso;
	}

	@DeleteMapping("/cursos/{id}")
	public Boolean delete(@PathVariable Integer id) {
		return this.CursoService.delete(id);

	}
}
