package mx.com.microservicio.apg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.com.microservicio.apg.entities.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String>{}
