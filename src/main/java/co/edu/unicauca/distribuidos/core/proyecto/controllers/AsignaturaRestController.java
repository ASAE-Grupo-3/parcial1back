package co.edu.unicauca.distribuidos.core.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.AsignaturaDTO;
import co.edu.unicauca.distribuidos.core.proyecto.services.services.clienteServices.IAsignaturaService;

@RestController
@RequestMapping("/api")
public class AsignaturaRestController {

    @Autowired
    IAsignaturaService asignaturaService;

    @GetMapping("/asignaturas")
	public List<AsignaturaDTO> index() {
		return asignaturaService.findAll();
	}

	@GetMapping("/asignaturas/{id}")
	public AsignaturaDTO show(@PathVariable Integer id) {
		AsignaturaDTO objasignatura = null;
		objasignatura = asignaturaService.findById(id);
		return objasignatura;
	}

	@PostMapping("/asignaturas")
	public AsignaturaDTO create(@RequestBody AsignaturaDTO asignaturaDTO) {
		AsignaturaDTO objAsignaturaDTO = null;
		objAsignaturaDTO = asignaturaService.save(asignaturaDTO);
		return objAsignaturaDTO;
	}
    
}
