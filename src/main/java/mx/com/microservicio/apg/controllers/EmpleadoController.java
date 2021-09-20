package mx.com.microservicio.apg.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import mx.com.microservicio.apg.entities.Empleado;
import mx.com.microservicio.apg.services.EmpleadoService;

@RestController
@CrossOrigin(origins = "*")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping(value = "empleados",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Empleado>> listarEmpleados(){
		return new ResponseEntity<List<Empleado>>(empleadoService.consultar(),HttpStatus.OK);
	}
	
	@PostMapping(value = "empleados", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empleado> guardarEmpleado(@RequestBody Empleado empleado) {
			return new ResponseEntity<Empleado>(empleadoService.alta(empleado), HttpStatus.CREATED);
	}
	
	@PostMapping(value = "empleados/{matricula}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable("matricula") String matricula, @RequestBody Empleado empleado){
		return new ResponseEntity<Empleado>(empleadoService.modificar(matricula, empleado),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "empleados/{matricula}")
	public ResponseEntity<Void> eliminarEmpleado(@PathVariable("matricula") String matricula) {
		empleadoService.eliminar(matricula);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
