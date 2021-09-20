package mx.com.microservicio.apg.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import mx.com.microservicio.apg.entities.Empleado;
import mx.com.microservicio.apg.repositories.EmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	public List<Empleado> consultar(){
		return (List<Empleado>) empleadoRepository.findAll();
	}
	
	public Empleado alta(Empleado empleado) {
		Optional<Empleado> resultado = empleadoRepository.findById(empleado.getMatricula());
		if (!resultado.isPresent()) {
			return empleadoRepository.save(empleado);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Empleado existente", empleado.getMatricula()));
		}
	}
	
	public Empleado modificar(String id,Empleado empleado) {
		Optional<Empleado> resultado = empleadoRepository.findById(id);
		if (resultado.isPresent()) {
			empleado.setFechaAlta(resultado.get().getFechaAlta());
			return empleadoRepository.save(empleado);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Empleado no existente", id));
		}
	}
	
	public void eliminar(String id) {
		Optional<Empleado> resultado = empleadoRepository.findById(id);
		if (resultado.isPresent()) {
			empleadoRepository.delete(resultado.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Empleado no existente", id));
		}
	}
	
}
