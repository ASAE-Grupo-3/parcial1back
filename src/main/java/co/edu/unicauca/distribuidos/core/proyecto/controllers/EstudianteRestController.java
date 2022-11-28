
package co.edu.unicauca.distribuidos.core.proyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.distribuidos.core.proyecto.services.DTO.EstudianteDTO;
import co.edu.unicauca.distribuidos.core.proyecto.services.services.clienteServices.IEstudianteService;

import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/api")
@Validated
public class EstudianteRestController {

	@Autowired
	private IEstudianteService EstudianteService;

	@GetMapping("/estudiantes")
	public List<EstudianteDTO> index() {
		return EstudianteService.findAll();
	}

	@GetMapping("/estudiantes/{id}")
	public EstudianteDTO show( Integer id) {
		EstudianteDTO objCliente = null;
		objCliente = EstudianteService.findById(id);
		return objCliente;
	}

	@PostMapping("/estudiantes")
	public EstudianteDTO create( EstudianteDTO cliente) {
		EstudianteDTO objCliente = null;
		objCliente = EstudianteService.save(cliente);
		return objCliente;
	}

	@PutMapping("/estudiantes/{id}")
	public EstudianteDTO update( EstudianteDTO cliente, Integer id) {
		EstudianteDTO objCliente = null;
		System.out.println("actualizando cliente");
		EstudianteDTO clienteActual = EstudianteService.findById(id);
		if (clienteActual != null) {
			objCliente = EstudianteService.update(id, cliente);
		}
		return objCliente;
	}

	@DeleteMapping("/estudiantes/{id}")
	public Boolean delete( Integer id) {
		Boolean bandera = false;
		EstudianteDTO clienteActual = EstudianteService.findById(id);
		if (clienteActual != null) {
			bandera = EstudianteService.delete(id);
		}
		return bandera;

	}

}
